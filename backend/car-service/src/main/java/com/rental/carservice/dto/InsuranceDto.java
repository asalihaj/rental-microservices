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
    private String name;
    private Integer coverValue;
    private BigDecimal price;
    private Boolean isFixed;
}
