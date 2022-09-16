package com.rental.bookingservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CarDto {
    private UUID id;
    private String brand;
    private String model;
}
