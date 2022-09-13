package com.rental.carservice.dto.equipment;

import com.rental.carservice.dto.IdDto;
import lombok.Data;

import java.util.Set;

@Data
public class EquipmentCreationDto extends EquipmentDto {
    private Set<IdDto> groups;
}
