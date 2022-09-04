package com.rental.carservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Getter
@Setter
public class CarViewDto {
    private UUID id;
    private ModelDto model;
    private StatusDto status;
    private ColorDto color;
    private BigDecimal rentalRate;
    private String plateNumber;
    private CategoryDto category;
    private FuelTypeDto fuelType;
    private Set<UtilityDto> utilities;
    private Set<InsuranceDto> insurances;
}
