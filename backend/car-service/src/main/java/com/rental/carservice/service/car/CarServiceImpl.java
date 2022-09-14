package com.rental.carservice.service.car;

import com.rental.carservice.dto.*;
import com.rental.carservice.dto.car.*;
import com.rental.carservice.mapper.CarMapper;
import com.rental.carservice.model.*;
import com.rental.carservice.repository.*;
import com.rental.carservice.util.ObjectValidation;
import com.rental.carservice.util.PriceCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final StatusRepository statusRepository;
    private final ColorRepository colorRepository;
    private final CategoryRepository categoryRepository;
    private final ModelRepository modelRepository;
    private final FuelTypeRepository fuelTypeRepository;
    private final UtilityRepository utilityRepository;
    private final InsuranceRepository insuranceRepository;
    private final ObjectValidation validation;
    private final CarMapper carMapper;

    @Override
    public List<CarViewDto> getAll() {
        List<Car> cars = carRepository.findAll();
        List<CarViewDto> carViewDtos = new ArrayList<>();
        for (Car car : cars) {
            carViewDtos.add(carMapper.toDto(car));
        }
        return carViewDtos;
    }

    @Override
    public List<CarOfferDto> getAvailableCars(OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        //TODO: Add a pick-up and return location
        List<Car> carsData = carRepository.findAll();
        List<CarOfferDto> cars = new ArrayList<>();
        for (Car car : carsData) {
            if (car.getStatus().getName().equals("active")) {
                CarOfferDto carOfferDto = carMapper.toRangeDto(carMapper.toDto(car));
                carOfferDto.setTotalPrice(PriceCalculator.calculateTotalAmount(car, rentalDate, returnDate));
                cars.add(carOfferDto);
            }
        }
        return cars;
    }

    @Override
    public CarViewDto getById(UUID id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(carMapper::toDto).orElse(null);
    }

    @Override
    public List<CarViewDto> getByCompany(UUID companyId) {
        List<Car> cars = carRepository.findAllByUserId(companyId);
        List<CarViewDto> carsToReturn = new ArrayList<>();
        for (Car car : cars) {
            carsToReturn.add(carMapper.toDto(car));
        }
        return carsToReturn;
    }

    @Override
    public CarViewDto create(CarCreationDto carDto) {
        Car car = new Car();
        car.setModel(modelRepository.findById(carDto.getModel()).orElseThrow());
        car.setCategory(categoryRepository.findById(carDto.getCategory()).orElseThrow());
        car.setColor(colorRepository.findById(carDto.getColor()).orElseThrow());
        car.setGroup(groupRepository.findById(carDto.getGroup()).orElseThrow());
        car.setFuelType(fuelTypeRepository.findById(carDto.getFuelType()).orElseThrow());
        car.setStatus(statusRepository.findById(carDto.getStatus()).orElseThrow());
        car.setUser(userRepository.findById(carDto.getCompany()).orElseThrow());
        car.setDoors(carDto.getDoors());
        car.setSeats(carDto.getSeats());
        car.setProdYear(carDto.getProdYear());
        car.setPlateNumber(carDto.getPlateNumber());
        car.setDateCreated(OffsetDateTime.now());
        car.setLastUpdated(OffsetDateTime.now());
        car.setRentalRate(carDto.getRentalRate());
        List<UUID> utilities = carDto.getUtilities().stream().map(IdDto::getId).collect(Collectors.toList());
        List<UUID> insurances = carDto.getInsurances().stream().map(IdDto::getId).collect(Collectors.toList());
        car.setUtilities(new HashSet<>(utilityRepository.findAllById(utilities)));
        car.setInsurances(new HashSet<>(insuranceRepository.findAllById(insurances)));

        return carMapper.toDto(carRepository.save(car));
    }

    @Override
    public CarDetailsDto edit(UUID id, CarBaseDto carBaseDto) {
         Optional<Car> carData = carRepository.findById(id).map(car -> {
                  short seats = validation.setValue(carBaseDto.getSeats(), car.getSeats());
                  short doors = validation.setValue(carBaseDto.getDoors(), car.getDoors());
                  BigDecimal rentalRate = validation.setValue(carBaseDto.getRentalRate(), car.getRentalRate());
                  short prodYear = validation.setValue(carBaseDto.getProdYear(), car.getProdYear());
                  Status status = validation.getEntry(statusRepository.findById(carBaseDto.getStatus()));
                  Color color = validation.getEntry(colorRepository.findById(carBaseDto.getColor()));

                  car.setSeats(seats);
                  car.setDoors(doors);
                  car.setRentalRate(rentalRate);
                  car.setProdYear(prodYear);
                  car.setStatus(status);
                  car.setColor(color);
                  car.setLastUpdated(OffsetDateTime.now());

                  return carRepository.save(car);
         });

         return carData.map(carMapper::toDetailsDto).orElse(null);
    }

    @Override
    public int addUtility(UUID carId, UUID utilityId) {
        Car car = validation.getEntry(carRepository.findById(carId));
        Utility utility = validation.getEntry(utilityRepository.findById(utilityId));
        if (car != null && utility != null) {
            boolean isAdded = car.getUtilities().add(utility);
            if (!isAdded) {
                return 410;
            }
            carRepository.save(car);
            return 204;
        }
        return 404;
    }

    @Override
    public int addInsurance(UUID carId, UUID insuranceId) {
        Car car = validation.getEntry(carRepository.findById(carId));
        Insurance insurance = validation.getEntry(insuranceRepository.findById(insuranceId));
        if (car != null && insurance != null) {
            boolean isAdded = car.getInsurances().add(insurance);
            if (!isAdded) {
                return 410;
            }
            carRepository.save(car);
            return 204;
        }
        return 404;
    }

    @Override
    public int removeUtility(UUID carId, UUID utilityId) {
        Car car = validation.getEntry(carRepository.findById(carId));
        Utility utility = validation.getEntry(utilityRepository.findById(utilityId));
        if (car != null && utility != null) {
            boolean isRemoved = car.getUtilities().remove(utility);
            if (!isRemoved) {
                return 410;
            }
            carRepository.save(car);
            return 204;
        }
        return 404;
    }

    @Override
    public int removeInsurance(UUID carId, UUID insuranceId) {
        Car car = validation.getEntry(carRepository.findById(carId));
        Insurance insurance = validation.getEntry(insuranceRepository.findById(insuranceId));
        if (car != null && insurance != null) {
            boolean isRemoved = car.getInsurances().remove(insurance);
            if (!isRemoved) {
                return 410;
            }
            carRepository.save(car);
            return 204;
        }
        return 404;
    }

    @Override
    public void deleteById(UUID id) {
        carRepository.deleteById(id);
    }
}
