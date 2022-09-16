package com.rental.bookingservice.mapper;

import com.rental.bookingservice.dto.CouponTypeDto;
import com.rental.bookingservice.model.CouponType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CouponTypeMapper {
    @Mapping(source = "couponableType", target = "type")
    CouponTypeDto toDto(CouponType type);
}
