package com.rental.carservice.repository;

import com.rental.carservice.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, UUID> {
}
