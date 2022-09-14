package com.rental.carservice.service.season;

import com.rental.carservice.dto.SeasonDto;

import java.util.List;
import java.util.UUID;

public interface SeasonService {
    List<SeasonDto> getAll(UUID companyId);
    SeasonDto create(SeasonDto seasonDto);
    SeasonDto edit(UUID id, SeasonDto seasonDto);
    void delete(UUID id);
}
