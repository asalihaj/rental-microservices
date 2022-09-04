package com.rental.carservice.mapper;

import com.rental.carservice.dto.UtilityDto;
import com.rental.carservice.model.Utility;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilityMapper {
    UtilityDto toDto(Utility utility);
}
