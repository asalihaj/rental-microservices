package com.rental.carservice.mapper;

import com.rental.carservice.dto.equipment.EquipmentDto;
import com.rental.carservice.model.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    @Mapping(source = "fixed", target = "isFixed")
    EquipmentDto toDto(Equipment equipment);
}
