package com.rental.carservice.service.equipment;

import com.rental.carservice.dto.equipment.EquipmentCreationDto;
import com.rental.carservice.dto.equipment.EquipmentDto;

import java.util.List;
import java.util.UUID;

public interface EquipmentService {
    List<EquipmentDto> getAll();
    EquipmentDto create(EquipmentCreationDto equipmentDto);
    EquipmentDto edit(UUID id, EquipmentDto equipmentDto);
    int addToGroup(UUID equipmentId, UUID groupId);
    int removeFromGroup(UUID equipmentId, UUID groupId);
    void delete(UUID id);
}
