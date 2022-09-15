package com.rental.carservice.mapper;

import com.rental.carservice.dto.photo.PhotoDto;
import com.rental.carservice.model.Photo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    @Mapping(source = "main", target = "isMain")
    PhotoDto toDto(Photo photo);
}
