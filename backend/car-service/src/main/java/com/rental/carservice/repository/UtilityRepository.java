package com.rental.carservice.repository;

import com.rental.carservice.model.Utility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UtilityRepository extends JpaRepository<Utility, UUID> {
}
