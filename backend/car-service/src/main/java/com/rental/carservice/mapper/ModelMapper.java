package com.rental.carservice.mapper;

import com.rental.carservice.dto.ModelDto;
import com.rental.carservice.model.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    @Mapping(source = "brand.name", target = "brand")
    ModelDto toDto(Model model);
}
