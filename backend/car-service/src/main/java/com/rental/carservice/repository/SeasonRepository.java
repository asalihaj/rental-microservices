package com.rental.carservice.repository;

import com.rental.carservice.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeasonRepository extends JpaRepository<Season, UUID> {
}
