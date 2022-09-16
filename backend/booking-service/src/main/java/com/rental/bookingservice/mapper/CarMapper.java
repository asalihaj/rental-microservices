package com.rental.bookingservice.mapper;

import com.rental.bookingservice.dto.CarDto;
import com.rental.bookingservice.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto toDto(Car car);
}
