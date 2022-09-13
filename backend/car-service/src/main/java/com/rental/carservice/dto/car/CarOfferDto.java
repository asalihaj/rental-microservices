package com.rental.carservice.dto.car;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarOfferDto extends CarViewDto {
    private BigDecimal totalPrice;
}
