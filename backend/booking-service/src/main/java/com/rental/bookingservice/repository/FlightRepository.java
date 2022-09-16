package com.rental.bookingservice.repository;

import com.rental.bookingservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
}
