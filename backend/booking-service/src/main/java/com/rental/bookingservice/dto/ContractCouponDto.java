package com.rental.bookingservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ContractCouponDto {
    private UUID contract;
    private CouponDto coupon;
}
