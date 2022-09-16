package com.rental.bookingservice.mapper;

import com.rental.bookingservice.dto.ContractCouponDto;
import com.rental.bookingservice.model.ContractCoupon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {CouponMapper.class})
public interface ContractCouponMapper {
    @Mapping(source = "contract.id", target = "contract")
    ContractCouponDto toDto(ContractCoupon contractCoupon);
}
