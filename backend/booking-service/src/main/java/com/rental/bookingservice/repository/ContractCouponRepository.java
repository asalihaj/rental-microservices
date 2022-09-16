package com.rental.bookingservice.repository;

import com.rental.bookingservice.model.ContractCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContractCouponRepository extends JpaRepository<ContractCoupon, UUID> {
}
