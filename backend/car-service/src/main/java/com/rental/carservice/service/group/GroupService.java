package com.rental.carservice.service.group;

import com.rental.carservice.dto.group.GroupCreationDto;
import com.rental.carservice.dto.group.GroupDto;
import com.rental.carservice.model.Group;

import java.util.List;
import java.util.UUID;

public interface GroupService {
    List<GroupDto> getAll(UUID companyId);
    GroupDto create(GroupCreationDto groupDto);
    GroupDto edit(UUID id, GroupDto groupDto);
    void editCarGroup(UUID carId, UUID groupId);
    int delete(UUID id);
}
