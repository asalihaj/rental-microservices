package com.rental.carservice.mapper;

import com.rental.carservice.dto.car.CarViewDto;
import com.rental.carservice.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {ColorMapper.class, UtilityMapper.class,
                InsuranceMapper.class, EquipmentMapper.class})
public interface CarMapper {
    @Mapping(source = "model.brand.name", target = "brand")
    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "category.name", target = "category")
    @Mapping(source = "fuelType.name", target = "fuelType")
    @Mapping(source = "group.name", target = "group")
    @Mapping(source = "group.equipments", target = "equipments")
    @Mapping(source = "user.username", target = "company")
    CarViewDto toDto(Car car);
}
