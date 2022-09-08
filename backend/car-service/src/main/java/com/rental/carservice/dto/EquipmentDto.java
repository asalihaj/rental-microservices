package com.rental.carservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EquipmentDto {
    private String name;
    private BigDecimal price;
    private int maxPerOrder;
    private boolean isFixed;
}
