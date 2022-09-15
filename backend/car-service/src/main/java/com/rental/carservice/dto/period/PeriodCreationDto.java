package com.rental.carservice.dto.period;

import lombok.Data;

import java.util.UUID;

@Data
public class PeriodCreationDto extends PeriodDto {
    private UUID company;
}
