package com.rental.carservice.service;

import com.rental.carservice.dto.CarViewDto;
import com.rental.carservice.mapper.CarMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public List<CarViewDto> getCarList() {
        List<Car> cars = carRepository.findAll();
        List<CarViewDto> carViewDtos = new ArrayList<>();
        for (Car car : cars) {
            carViewDtos.add(carMapper.toDto(car));
        }
        return carViewDtos;
    }

    @Override
    public CarViewDto getCar(UUID id) {
        Optional<Car> car = carRepository.findById(id);

        return car.map(carMapper::toDto).orElse(null);
    }

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car editCar(UUID id, Car car) {
        return carRepository.findById(id).isPresent() ? carRepository.save(car) : null;
    }

    @Override
    public boolean deleteCar(UUID id) {
        carRepository.deleteById(id);
        return carRepository.findById(id).isEmpty();
    }
}
