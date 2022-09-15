package com.rental.carservice.repository;

import com.rental.carservice.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SeasonRepository extends JpaRepository<Season, UUID> {
    List<Season> findAllByCompanyId(UUID companyId);
}
