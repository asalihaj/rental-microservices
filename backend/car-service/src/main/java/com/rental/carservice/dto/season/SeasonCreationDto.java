package com.rental.carservice.dto.season;

import lombok.Data;

import java.util.UUID;

@Data
public class SeasonCreationDto {
    private String name;
    private String description;
    private String  startDate;
    private String  endDate;
    private Integer changeValue;
    private Boolean isFixed;
    private UUID company;
}
