package com.rental.carservice.dto;

import lombok.Data;

@Data
public class PeriodDto {
    private String name;
    private int startDay;
    private int endDay;
    private int changeValue;
    private boolean isFixed;
}
