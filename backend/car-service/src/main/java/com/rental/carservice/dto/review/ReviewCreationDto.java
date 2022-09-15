package com.rental.carservice.dto.review;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewCreationDto {
    private Short stars;
    private String comment;
    private UUID client;
    private UUID car;

}
