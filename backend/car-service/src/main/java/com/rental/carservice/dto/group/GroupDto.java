package com.rental.carservice.dto.group;

import com.rental.carservice.dto.period.PeriodDto;
import com.rental.carservice.dto.season.SeasonDto;
import lombok.Data;

import java.util.Set;

@Data
public class GroupDto {
    private String name;
    private String description;
    private Set<SeasonDto> seasons;
    private Set<PeriodDto> periods;
}
