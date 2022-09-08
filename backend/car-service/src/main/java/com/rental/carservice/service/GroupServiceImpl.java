package com.rental.carservice.service;

import com.rental.carservice.dto.GroupDto;
import com.rental.carservice.mapper.GroupMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Group;
import com.rental.carservice.repository.CarRepository;
import com.rental.carservice.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final CarRepository carRepository;
    private final GroupMapper groupMapper;

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
    public Group get(UUID id) {
        return null;
    }

    @Override
    public Group create(Group group) {
        return null;
    }

    @Override
    public Group edit(UUID id, Group group) {
        return null;
    }

    @Override
    public void editCarGroup(UUID carId, UUID groupId) {
        Car car = carRepository.findById(carId).orElseThrow();
        car.setGroup(groupRepository.findById(groupId).orElseThrow());
        carRepository.save(car);
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }
}
