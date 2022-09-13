package com.rental.carservice.mapper;

import com.rental.carservice.dto.BrandDto;
import com.rental.carservice.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandDto toDto(Brand brand);
}
