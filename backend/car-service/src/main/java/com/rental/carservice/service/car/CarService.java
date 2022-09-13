package com.rental.carservice.service.car;

import com.rental.carservice.dto.CategoryDto;
import com.rental.carservice.dto.ColorDto;
import com.rental.carservice.dto.FuelTypeDto;
import com.rental.carservice.dto.ModelDto;
import com.rental.carservice.dto.car.*;
import com.rental.carservice.model.Car;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface CarService {
    List<CarViewDto> getAll();
    //TODO: Add location to getAvailableCars
    List<CarOfferDto> getAvailableCars(OffsetDateTime rentalDate, OffsetDateTime returnDate);
    CarViewDto getById(UUID id);
    List<CarViewDto> getByCompany(UUID companyId);
    CarViewDto create(CarCreationDto car);
    CarDetailsDto edit(UUID id, CarBaseDto carBaseDto);
    int addUtility(UUID carId, UUID utilityId);
    int addInsurance(UUID carId, UUID insuranceId);
    int removeUtility(UUID carId, UUID utilityId);
    int removeInsurance(UUID carId, UUID insuranceId);
    void deleteById(UUID id);
}
