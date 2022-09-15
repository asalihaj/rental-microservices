package com.rental.carservice.repository;

import com.rental.carservice.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID> {
    List<Group> findAllByCompanyId(UUID companyId);
}
