package com.rental.carservice.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SeasonDto {
    private String name;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private int changeValue;
    private boolean isFixed;
}
