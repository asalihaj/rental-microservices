package com.rental.bookingservice.dto.contract;

import com.rental.bookingservice.dto.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

@Data
public class ContractDto {
    private UUID id;
    private OffsetDateTime rentalDate;
    private OffsetDateTime returnDate;
    private BigDecimal totalPrice;
    private ClientDto client;
    private CarDto car;
    private Set<InsuranceDto> insurances;
    private FlightDto flight;
    private CouponDto coupon;
}
