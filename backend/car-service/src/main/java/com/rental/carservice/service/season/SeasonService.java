package com.rental.carservice.service.season;

import com.rental.carservice.dto.SeasonDto;

import java.util.List;
import java.util.UUID;

public interface SeasonService {
    List<SeasonDto> getAll();
    SeasonDto create(SeasonDto seasonDto);
    SeasonDto edit(SeasonDto seasonDto);
    void delete(UUID id);
}
