package com.rental.carservice.repository;

import com.rental.carservice.model.Car;
import com.rental.carservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    List<Car> findByUser(User user);
}
