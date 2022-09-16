package com.rental.bookingservice.dto.contract;

import com.rental.bookingservice.dto.IdDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
public class ContractCreationDto {
    private String rentalDate;
    private String returnDate;
    private BigDecimal totalPrice;
    private UUID client;
    private UUID car;
    private Set<IdDto> insurances;
    private String flightNumber;
    private UUID coupon;
}
