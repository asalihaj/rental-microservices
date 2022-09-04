package com.rental.carservice.service;

import com.rental.carservice.dto.CarViewDto;
import com.rental.carservice.model.Car;

import java.util.List;
import java.util.UUID;

public interface CarService {
    public abstract List<CarViewDto> getCarList();
    public abstract CarViewDto getCar(UUID id);
    public abstract Car createCar(Car car);
    public abstract Car editCar(UUID id, Car car);
    public abstract boolean deleteCar(UUID id);
}
