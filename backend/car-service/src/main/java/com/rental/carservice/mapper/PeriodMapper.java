package com.rental.carservice.mapper;

import com.rental.carservice.dto.period.PeriodDto;
import com.rental.carservice.model.Period;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PeriodMapper {
    @Mapping(source = "fixed", target = "isFixed")
    PeriodDto toDto(Period period);
}
