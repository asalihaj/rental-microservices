package com.rental.carservice.service.insurance;

import com.rental.carservice.dto.InsuranceDto;

import java.util.List;
import java.util.UUID;

public interface InsuranceService {
    List<InsuranceDto> getAll(UUID companyId);
    InsuranceDto create(InsuranceDto insuranceDto);
    int edit(UUID id, InsuranceDto insuranceDto);
    void delete(UUID id);
}
