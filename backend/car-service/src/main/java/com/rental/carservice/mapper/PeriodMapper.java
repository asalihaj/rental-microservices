package com.rental.carservice.mapper;

import com.rental.carservice.dto.PeriodDto;
import com.rental.carservice.model.Period;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PeriodMapper {
    PeriodDto toDto(Period period);
}
