package com.rental.carservice.dto.insurance;

import lombok.Data;

import java.util.UUID;

@Data
public class InsuranceCreationDto extends InsuranceDto {
    private UUID company;
}
