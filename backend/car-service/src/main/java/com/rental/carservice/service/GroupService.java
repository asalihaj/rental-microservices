package com.rental.carservice.service;

import com.rental.carservice.dto.GroupDto;
import com.rental.carservice.model.Group;

import java.util.List;
import java.util.UUID;

public interface GroupService {
    public List<GroupDto> getAll();
    public Group get(UUID id);
    public Group create(Group group);
    public Group edit(UUID id, Group group);
    public void editCarGroup(UUID carId, UUID groupId);
    public boolean delete(UUID id);
}
