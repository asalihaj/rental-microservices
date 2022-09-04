package com.rental.carservice.mapper;

import com.rental.carservice.dto.InsuranceDto;
import com.rental.carservice.model.Insurance;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {
    InsuranceDto toDto(Insurance insurance);
}
