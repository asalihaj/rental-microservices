package com.rental.carservice.mapper;

import com.rental.carservice.dto.ColorDto;
import com.rental.carservice.model.Color;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    ColorDto toDto(Color color);
}
