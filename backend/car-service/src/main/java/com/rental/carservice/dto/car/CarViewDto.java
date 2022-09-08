package com.rental.carservice.dto.car;

import com.rental.carservice.dto.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
public class CarViewDto {
    private UUID id;
    private String company;
    private String brand;
    private String model;
    private String fuelType;
    private String category;
    private String group;
    private BigDecimal rentalRate;
    private ColorDto color;
    private Set<UtilityDto> utilities;
    private Set<InsuranceDto> insurances;
    private Set<EquipmentDto> equipments;
}
