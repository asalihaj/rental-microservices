package com.rental.carservice.repository;

import com.rental.carservice.model.ReportCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReportCategoryRepository extends JpaRepository<ReportCategory, UUID> {
}
