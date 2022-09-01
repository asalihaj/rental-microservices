package com.rental.carservice.repository;

import com.rental.carservice.model.Period;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PeriodRepository extends JpaRepository<Period, UUID> {
}
