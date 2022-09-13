package com.rental.carservice.dto.equipment;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EquipmentDto {
    private String name;
    private BigDecimal price;
    private Integer maxPerOrder;
    private Boolean isFixed;
}
