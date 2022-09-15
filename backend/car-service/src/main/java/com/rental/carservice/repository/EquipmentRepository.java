package com.rental.carservice.repository;

import com.rental.carservice.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
    List<Equipment> findAllByCompanyId(UUID companyId);
}
