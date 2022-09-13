package com.rental.carservice.dto.review;

import lombok.Data;

import java.util.UUID;

@Data
public class ReviewCreationDto {
    private short stars;
    private String comment;
    private UUID user;
    private UUID car;

}
