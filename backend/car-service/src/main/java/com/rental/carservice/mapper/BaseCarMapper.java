package com.rental.carservice.mapper;

import com.rental.carservice.dto.car.CarBaseDto;
import com.rental.carservice.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaseCarMapper {
    Car toEntity(CarBaseDto carBaseDto);
}
