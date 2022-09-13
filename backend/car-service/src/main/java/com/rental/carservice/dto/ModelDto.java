package com.rental.carservice.dto;

import lombok.*;

import java.util.UUID;

@Data
public class ModelDto {
    private UUID id;
    private String brand;
    private String name;
}
