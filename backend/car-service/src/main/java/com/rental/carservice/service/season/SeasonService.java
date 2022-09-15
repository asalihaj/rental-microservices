package com.rental.carservice.service.season;

import com.rental.carservice.dto.season.SeasonCreationDto;
import com.rental.carservice.dto.season.SeasonDto;

import java.util.List;
import java.util.UUID;

public interface SeasonService {
    List<SeasonDto> getAll(UUID companyId);
    SeasonDto create(SeasonCreationDto seasonDto);
    SeasonDto edit(UUID id, SeasonCreationDto seasonDto);
    int addToGroup(UUID seasonId, UUID groupId);
    int removeFromGroup(UUID seasonId, UUID groupId);
    int delete(UUID id);
}
