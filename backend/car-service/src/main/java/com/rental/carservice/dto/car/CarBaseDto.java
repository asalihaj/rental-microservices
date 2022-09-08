package com.rental.carservice.dto.car;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class CarBaseDto {
    private UUID id;
    private Short doors;
    private Short seats;
    private Short prodYear;
    private String plateNumber;
    private BigDecimal rentalRate;
}
