package com.rental.carservice.mapper;

import com.rental.carservice.dto.GroupDto;
import com.rental.carservice.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {EquipmentMapper.class, PeriodMapper.class,
                SeasonMapper.class})
public interface GroupMapper {
    GroupDto toDto(Group group);
}
