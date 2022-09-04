package com.rental.carservice.mapper;

import com.rental.carservice.dto.FuelTypeDto;
import com.rental.carservice.model.FuelType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuelTypeMapper {
    FuelTypeDto toDto(FuelType fuelType);
}
