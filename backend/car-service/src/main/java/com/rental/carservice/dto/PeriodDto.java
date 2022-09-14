package com.rental.carservice.dto;

import lombok.Data;

@Data
public class PeriodDto {
    private String name;
    private Short startDay;
    private Short endDay;
    private Integer changeValue;
    private Boolean isFixed;
}
