package com.rental.carservice.mapper;

import com.rental.carservice.dto.CategoryDto;
import com.rental.carservice.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
}
