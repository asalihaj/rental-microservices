package com.rental.carservice.repository;

import com.rental.carservice.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelTypeRepository extends JpaRepository<FuelType, UUID> {
}
