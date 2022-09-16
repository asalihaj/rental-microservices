package com.rental.bookingservice.repository;

import com.rental.bookingservice.model.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserClientRepository extends JpaRepository<UserClient, UUID> {
}
