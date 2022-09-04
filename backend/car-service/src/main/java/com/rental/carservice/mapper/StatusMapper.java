package com.rental.carservice.mapper;

import com.rental.carservice.dto.StatusDto;
import com.rental.carservice.model.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusDto toDto(Status status);
}
