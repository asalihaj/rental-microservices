package com.rental.carservice.mapper;

import com.rental.carservice.dto.review.ReviewDto;
import com.rental.carservice.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    ReviewDto toDto(Review review);
}
