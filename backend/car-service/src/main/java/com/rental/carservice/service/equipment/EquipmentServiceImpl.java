package com.rental.carservice.service.equipment;

import com.rental.carservice.dto.IdDto;
import com.rental.carservice.dto.equipment.EquipmentCreationDto;
import com.rental.carservice.dto.equipment.EquipmentDto;
import com.rental.carservice.mapper.EquipmentMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Equipment;
import com.rental.carservice.model.Group;
import com.rental.carservice.repository.EquipmentRepository;
import com.rental.carservice.repository.GroupRepository;
import com.rental.carservice.util.ObjectValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {
    private final EquipmentRepository equipmentRepository;
    private final GroupRepository groupRepository;
    private final EquipmentMapper equipmentMapper;
    private final ObjectValidation validation;

    @Override
    public List<EquipmentDto> getAll() {
        return equipmentRepository
                .findAll().stream()
                .map(equipmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EquipmentDto create(EquipmentCreationDto equipmentDto) {
        Equipment equipment = new Equipment();
        equipment.setName(equipmentDto.getName());
        equipment.setPrice(equipmentDto.getPrice());
        equipment.setFixed(equipmentDto.getIsFixed());
        List<UUID> groups = equipmentDto.getGroups().stream().map(IdDto::getId).collect(Collectors.toList());
        equipment.setGroups(new HashSet<>(groupRepository.findAllById(groups)));
        equipment.setMaxPerOrder(equipmentDto.getMaxPerOrder());
        equipment.setLastUpdated(OffsetDateTime.now());

        return equipmentMapper.toDto(equipmentRepository.save(equipment));
    }

    @Override
    public EquipmentDto edit(UUID id, EquipmentDto equipmentDto) {
        Equipment equipment = new Equipment();
        String name = validation.setValue(equipmentDto.getName(), equipment.getName());
        BigDecimal price = validation.setValue(equipmentDto.getPrice(), equipment.getPrice());
        boolean isFixed = validation.setValue(equipmentDto.getIsFixed(), equipment.isFixed());
        int maxPerOrder = validation.setValue(equipmentDto.getMaxPerOrder(), equipment.getMaxPerOrder());

        equipment.setName(name);
        equipment.setPrice(price);
        equipment.setFixed(isFixed);
        equipment.setMaxPerOrder(maxPerOrder);
        equipment.setLastUpdated(OffsetDateTime.now());

        return equipmentMapper.toDto(equipmentRepository.save(equipment));
    }

    @Override
    public int addToGroup(UUID equipmentId, UUID groupId) {
        Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);
        Optional<Group> group = groupRepository.findById(groupId);
        if (equipment.isPresent() && group.isPresent()) {
            boolean isAdded = equipment.get().getGroups().add(group.get());
            if (!isAdded) {
                return 410;
            }
            equipmentRepository.save(equipment.get());
            return 204;
        }
        return 404;
    }

    @Override
    public int removeFromGroup(UUID equipmentId, UUID groupId) {
        Equipment equipment = validation.getEntry(equipmentRepository.findById(equipmentId));
        Group group = validation.getEntry(groupRepository.findById(groupId));
        if (equipment != null && group != null) {
            boolean isRemoved = equipment.getGroups().remove(group);
            if (!isRemoved) {
                return 410;
            }
            equipmentRepository.save(equipment);
            return 204;
        }
        return 404;
    }

    @Override
    public void delete(UUID id) {
        equipmentRepository.deleteById(id);
    }
}
