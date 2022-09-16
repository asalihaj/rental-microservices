package com.rental.bookingservice.dto;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class CouponDto {
    private OffsetDateTime startDate;
    private OffsetDateTime endDate;
    private String code;
    private Integer changeValue;
    private Boolean isFixed;
    private CouponTypeDto type;
}
