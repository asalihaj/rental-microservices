package com.rental.carservice.dto.car;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarBaseDto {
    private Short doors;
    private Short seats;
    private Short prodYear;
    private String plateNumber;
    private BigDecimal rentalRate;
    private UUID status;
    private UUID color;
}
