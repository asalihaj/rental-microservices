package com.rental.carservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceDto {
    private UUID id;
    private String name;
    private int coverValue;
    private BigDecimal price;
    private boolean isFixed;
    private OffsetDateTime lastUpdated;
}
