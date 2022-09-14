package com.rental.carservice.mapper;

import com.rental.carservice.dto.photo.PhotoDto;
import com.rental.carservice.model.Photo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoDto toDto(Photo photo);
}
