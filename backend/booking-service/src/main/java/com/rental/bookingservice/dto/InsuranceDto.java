package com.rental.bookingservice.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class InsuranceDto {
    private UUID id;
    private BigDecimal price;
}
