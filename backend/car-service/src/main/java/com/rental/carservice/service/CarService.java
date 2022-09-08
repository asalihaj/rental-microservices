package com.rental.carservice.service;

import com.rental.carservice.dto.car.*;
import com.rental.carservice.model.Car;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface CarService {
    public abstract List<CarViewDto> getList();
    //TODO: Add location to getAvailableCars
    public abstract List<Object> getAvailableCars(OffsetDateTime rentalDate, OffsetDateTime returnDate);
    public abstract CarViewDto get(UUID id);
    public abstract List<CarViewDto> getByCompany(UUID companyId);
    public abstract CarViewDto create(CarCreationDto car);
    public abstract Car edit(UUID id, CarBaseDto carBaseDto);
    public abstract boolean delete(UUID id);
}
