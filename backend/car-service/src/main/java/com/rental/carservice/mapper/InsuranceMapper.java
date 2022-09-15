package com.rental.carservice.mapper;

import com.rental.carservice.dto.insurance.InsuranceDto;
import com.rental.carservice.model.Insurance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {
    @Mapping(source = "fixed", target = "isFixed")
    InsuranceDto toDto(Insurance insurance);
}
