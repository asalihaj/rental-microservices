package com.rental.bookingservice.repository;

import com.rental.bookingservice.model.CouponType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CouponTypeRepository extends JpaRepository<CouponType, UUID> {
}
