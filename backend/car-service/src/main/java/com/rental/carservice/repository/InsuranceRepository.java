package com.rental.carservice.repository;

import com.rental.carservice.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsuranceRepository extends JpaRepository<Insurance, UUID> {
}
