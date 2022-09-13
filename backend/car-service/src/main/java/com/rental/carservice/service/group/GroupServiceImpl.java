package com.rental.carservice.service.group;

import com.rental.carservice.dto.group.GroupCreationDto;
import com.rental.carservice.dto.group.GroupDto;
import com.rental.carservice.mapper.GroupMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Group;
import com.rental.carservice.repository.*;
import com.rental.carservice.util.ObjectValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CarRepository carRepository;
    private final GroupMapper groupMapper;
    private final ObjectValidation validation;

    @Override
    public List<GroupDto> getAll() {
        List<Group> groupsData = groupRepository.findAll();
        List<GroupDto> groups = new ArrayList<>();
        for (Group group : groupsData) {
            groups.add(groupMapper.toDto(group));
        }
        return groups;
    }

    @Override
    public GroupDto create(GroupCreationDto groupDto) {
        Group group = new Group();
        group.setName(groupDto.getName());
        group.setDescription(groupDto.getDescription());
        return groupMapper.toDto(groupRepository.save(group));
    }

    @Override
    public GroupDto edit(UUID id, GroupDto groupDto) {
        Optional<Group> groupData = groupRepository.findById(id).map(
                group -> {
                    String name = validation.setValue(groupDto.getName(), group.getName());
                    String description = validation.setValue(groupDto.getDescription(), group.getDescription());

                    group.setName(name);
                    group.setDescription(description);
                    group.setLastUpdated(OffsetDateTime.now());

                    return groupRepository.save(group);
                }
        );
        return groupData.map(groupMapper::toDto).orElse(null);
    }

    @Override
    public void editCarGroup(UUID carId, UUID groupId) {
        Car car = validation.getEntry(carRepository.findById(carId));
        car.setGroup(groupRepository.findById(groupId).orElseThrow());
        carRepository.save(car);
    }

    @Override
    public void delete(UUID id) {
        groupRepository.deleteById(id);
    }
}
