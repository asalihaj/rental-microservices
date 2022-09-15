package com.rental.carservice.mapper;

import com.rental.carservice.dto.season.SeasonDto;
import com.rental.carservice.model.Season;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    @Mapping(source = "fixed", target = "isFixed")
    SeasonDto toDto(Season season);
}
