package com.rental.securityjwtservice.repository;

import com.rental.securityjwtservice.model.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScopeRepository extends JpaRepository<Scope, UUID> {
}
