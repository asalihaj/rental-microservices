package com.rental.carservice.service.insurance;

import com.rental.carservice.dto.insurance.InsuranceDto;

import java.util.List;
import java.util.UUID;

public interface InsuranceService {
    List<InsuranceDto> getAll(UUID companyId);
    InsuranceDto create(InsuranceDto insuranceDto);
    InsuranceDto edit(UUID id, InsuranceDto insuranceDto);
    int delete(UUID id);
}
