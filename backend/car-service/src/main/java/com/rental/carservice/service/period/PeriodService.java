package com.rental.carservice.service.period;

import com.rental.carservice.dto.PeriodDto;

import java.util.List;
import java.util.UUID;

public interface PeriodService {
    List<PeriodDto> getAll(UUID companyId);
    PeriodDto create(PeriodDto periodDto);
    PeriodDto edit(UUID id, PeriodDto periodDto);
    int addToGroup(UUID periodId, UUID groupId);
    int removeFromGroup(UUID periodId, UUID groupId);
    void delete(UUID id);
}
