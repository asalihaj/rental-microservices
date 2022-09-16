package com.rental.bookingservice.repository;

import com.rental.bookingservice.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {
}
