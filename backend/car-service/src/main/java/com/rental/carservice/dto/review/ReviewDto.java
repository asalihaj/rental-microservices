package com.rental.carservice.dto.review;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewDto {
    private UUID id;
    private Short stars;
    private String comment;
}
