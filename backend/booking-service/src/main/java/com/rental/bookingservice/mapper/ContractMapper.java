package com.rental.bookingservice.mapper;

import com.rental.bookingservice.dto.contract.ContractDto;
import com.rental.bookingservice.model.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {ClientMapper.class, CarMapper.class,
                InsuranceMapper.class, FlightMapper.class,
                CouponMapper.class})
public interface ContractMapper {
    @Mapping(source = "contractCoupon.coupon", target = "coupon")
    ContractDto toDto(Contract contract);
}
