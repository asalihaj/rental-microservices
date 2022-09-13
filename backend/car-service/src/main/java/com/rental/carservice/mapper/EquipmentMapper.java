package com.rental.carservice.mapper;

import com.rental.carservice.dto.equipment.EquipmentDto;
import com.rental.carservice.model.Equipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipmentMapper {
    EquipmentDto toDto(Equipment equipment);
}
