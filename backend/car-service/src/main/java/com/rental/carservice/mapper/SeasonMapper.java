package com.rental.carservice.mapper;

import com.rental.carservice.dto.SeasonDto;
import com.rental.carservice.model.Season;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    SeasonDto toDto(Season season);
}
