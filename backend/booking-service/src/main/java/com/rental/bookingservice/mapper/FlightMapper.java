package com.rental.bookingservice.mapper;

import com.rental.bookingservice.dto.FlightDto;
import com.rental.bookingservice.model.Flight;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightDto toDto(Flight flight);
}
