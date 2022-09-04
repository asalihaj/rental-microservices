package com.rental.carservice.mapper;

import com.rental.carservice.dto.GroupDto;
import com.rental.carservice.model.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDto toDto(Group group);
}
