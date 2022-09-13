package com.rental.carservice.service.period;

import com.rental.carservice.dto.PeriodDto;

import java.util.List;
import java.util.UUID;

public interface PeriodService {
    List<PeriodDto> getAll(UUID companyId);
    PeriodDto create(PeriodDto periodDto);
    PeriodDto edit(UUID id, PeriodDto periodDto);
    void delete(UUID id);
}
