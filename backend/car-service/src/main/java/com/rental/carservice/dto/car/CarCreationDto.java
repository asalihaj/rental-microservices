package com.rental.carservice.dto.car;

import com.rental.carservice.dto.IdDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class CarCreationDto {
    private UUID model;
    private String plateNumber;
    private UUID category;
    private UUID group;
    private UUID fuelType;
    private UUID color;
    private UUID company;
    private UUID status;
    private BigDecimal rentalRate;
    private short prodYear;
    private short seats;
    private short doors;
    private List<IdDto> utilities;
    private List<IdDto> insurances;
}
