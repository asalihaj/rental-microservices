package com.rental.carservice.dto;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
public class GroupDto {
    private String name;
    private OffsetDateTime lastUpdated;
    private Set<EquipmentDto> equipments;
    private Set<SeasonDto> seasons;
    private Set<PeriodDto> periods;
}
