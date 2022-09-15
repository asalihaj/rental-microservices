package com.rental.carservice.dto.season;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SeasonDto {
    private String name;
    private String description;
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private Integer changeValue;
    private Boolean isFixed;
}
