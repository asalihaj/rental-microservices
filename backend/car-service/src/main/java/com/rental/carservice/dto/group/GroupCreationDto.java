package com.rental.carservice.dto.group;

import lombok.Data;

import java.util.UUID;

@Data
public class GroupCreationDto {
    private String name;
    private String description;
    private UUID company;
}
