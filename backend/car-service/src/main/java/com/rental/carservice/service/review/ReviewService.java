package com.rental.carservice.service.review;

import com.rental.carservice.dto.review.ReviewCreationDto;
import com.rental.carservice.dto.review.ReviewDto;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<ReviewDto> getAll(UUID carId);
    List<ReviewDto> getAllFromClient(UUID clientId);
    ReviewDto create(ReviewCreationDto reviewDto);
    ReviewDto edit(UUID id, ReviewDto reviewDto);
    int delete(UUID id);
}
