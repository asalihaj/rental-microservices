package com.rental.carservice.service;

import com.rental.carservice.dto.IdDto;
import com.rental.carservice.dto.car.*;
import com.rental.carservice.mapper.CarMapper;
import com.rental.carservice.model.*;
import com.rental.carservice.repository.*;
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
    private final CarMapper carMapper;

    @Override
    public List<CarViewDto> getList() {
        List<Car> cars = carRepository.findAll();
        List<CarViewDto> carViewDtos = new ArrayList<>();
        for (Car car : cars) {
            carViewDtos.add(carMapper.toDto(car));
        }
        return carViewDtos;
    }

    @Override
    public List<Object> getAvailableCars(OffsetDateTime rentalDate, OffsetDateTime returnDate) {
        //TODO: Return list of available cars in dates & location
        // specified along with the price
        return null;
    }



    @Override
    public CarViewDto get(UUID id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(carMapper::toDto).orElse(null);
    }

    @Override
    public List<CarViewDto> getByCompany(UUID companyId) {
        Optional<User> company = userRepository.findById(companyId);
        if (company.isPresent()) {
            List<Car> cars = carRepository.findByUser(company.get());
            List<CarViewDto> carsToReturn = new ArrayList<>();
            for (Car car : cars) {
                carsToReturn.add(carMapper.toDto(car));
            }
            return carsToReturn;
        }
        return null;
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
    public Car edit(UUID id, CarBaseDto carBaseDto) {
        carRepository.findById(id)
                .map(car -> {
                  car.setSeats(carBaseDto.getSeats() != null ? carBaseDto.getSeats() : car.getSeats());
                  car.setDoors(carBaseDto.getDoors() != null ? carBaseDto.getDoors() : car.getDoors());
                  car.setProdYear(carBaseDto.getProdYear() != null ? carBaseDto.getProdYear() : car.getProdYear());
                  car.setRentalRate(carBaseDto.getRentalRate() != null ? carBaseDto.getRentalRate() : car.getRentalRate());
                  car.setLastUpdated(OffsetDateTime.now());
                    return carRepository.save(car);
                });

        return null;
    }

    @Override
    public boolean delete(UUID id) {
        carRepository.deleteById(id);
        return carRepository.findById(id).isEmpty();
    }
}
