package com.rental.carservice.mapper;

import com.rental.carservice.dto.CarViewDto;
import com.rental.carservice.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {ModelMapper.class, StatusMapper.class,
                ColorMapper.class, CategoryMapper.class,
                FuelTypeMapper.class, UtilityMapper.class,
                InsuranceMapper.class, GroupMapper.class})
public interface CarMapper {
    CarViewDto toDto(Car car);
}
