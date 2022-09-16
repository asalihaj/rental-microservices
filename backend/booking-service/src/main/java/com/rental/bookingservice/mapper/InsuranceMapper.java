package com.rental.bookingservice.mapper;

import com.rental.bookingservice.dto.InsuranceDto;
import com.rental.bookingservice.model.Insurance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {
    InsuranceDto toDto(Insurance insurance);
}
