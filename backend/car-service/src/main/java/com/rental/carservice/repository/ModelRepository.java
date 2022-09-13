package com.rental.carservice.repository;

import com.rental.carservice.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ModelRepository extends JpaRepository<Model, UUID> {
    List<Model> findModelsByBrandId(UUID id);
}
