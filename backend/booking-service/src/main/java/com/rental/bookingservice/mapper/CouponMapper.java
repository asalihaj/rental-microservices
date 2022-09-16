package com.rental.bookingservice.mapper;

import com.rental.bookingservice.dto.CouponDto;
import com.rental.bookingservice.model.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {CouponTypeMapper.class})
public interface CouponMapper {
    @Mapping(source = "fixed", target = "isFixed")
    CouponDto toDto(Coupon coupon);
}
