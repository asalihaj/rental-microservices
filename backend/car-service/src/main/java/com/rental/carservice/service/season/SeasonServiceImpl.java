package com.rental.carservice.service.season;

import com.rental.carservice.dto.season.SeasonCreationDto;
import com.rental.carservice.dto.season.SeasonDto;
import com.rental.carservice.mapper.SeasonMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Group;
import com.rental.carservice.model.Period;
import com.rental.carservice.model.Season;
import com.rental.carservice.repository.CarRepository;
import com.rental.carservice.repository.GroupRepository;
import com.rental.carservice.repository.SeasonRepository;
import com.rental.carservice.util.DateConverter;
import com.rental.carservice.util.ObjectValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonService {
    private final SeasonRepository seasonRepository;
    private final GroupRepository groupRepository;
    private final SeasonMapper seasonMapper;
    private final ObjectValidation validation;
    @Override
    public List<SeasonDto> getAll(UUID companyId) {
        return seasonRepository.findAllByCompanyId(companyId)
                .stream().map(seasonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SeasonDto create(SeasonCreationDto seasonDto) {
        Season season = new Season();

        season.setName(seasonDto.getName());
        season.setDescription(seasonDto.getDescription());
        season.setChangeValue(seasonDto.getChangeValue());
        season.setStartDate(DateConverter.toDate(seasonDto.getStartDate()));
        season.setEndDate(DateConverter.toDate(seasonDto.getEndDate()));
        season.setFixed(seasonDto.getIsFixed());
        season.setLastUpdated(OffsetDateTime.now());

        return seasonMapper.toDto(seasonRepository.save(season));
    }

    @Override
    public SeasonDto edit(UUID id, SeasonCreationDto seasonDto) {
        Optional<Season> seasonData = seasonRepository.findById(id).map(season -> {
                    String name = validation.setValue(seasonDto.getName(), season.getName());
                    String description = validation.setValue(seasonDto.getDescription(), season.getDescription());
                    int changeValue = validation.setValue(seasonDto.getChangeValue(), season.getChangeValue());
                    OffsetDateTime startDate = validation
                            .setValue(DateConverter.toDate(seasonDto.getStartDate()), season.getStartDate());
                    OffsetDateTime endDate = validation
                            .setValue(DateConverter.toDate(seasonDto.getEndDate()), season.getEndDate());
                    boolean isFixed = validation.setValue(seasonDto.getIsFixed(), season.isFixed());

                    season.setName(name);
                    season.setDescription(description);
                    season.setChangeValue(changeValue);
                    season.setStartDate(startDate);
                    season.setEndDate(endDate);
                    season.setFixed(isFixed);
                    season.setLastUpdated(OffsetDateTime.now());

                    return seasonRepository.save(season);
                });

        return seasonData.map(seasonMapper::toDto).orElse(null);
    }

    @Override
    public int addToGroup(UUID seasonId, UUID groupId) {
        Season season = validation.getEntry(seasonRepository.findById(seasonId));
        Group group = validation.getEntry(groupRepository.findById(groupId));
        if (season != null && group != null) {
            boolean isAdded = group.getSeasons().add(season);
            if (!isAdded) {
                return 409;
            }
            groupRepository.save(group);
            return 204;
        }
        return 404;
    }

    @Override
    public int removeFromGroup(UUID seasonId, UUID groupId) {
        Season season = validation.getEntry(seasonRepository.findById(seasonId));
        Group group = validation.getEntry(groupRepository.findById(groupId));
        if (season != null && group != null) {
            boolean isRemoved = group.getSeasons().remove(season);
            if (!isRemoved) {
                return 410;
            }
            groupRepository.save(group);
            return 204;
        }
        return 404;
    }

    @Override
    public int delete(UUID id) {
        Season season = validation.getEntry(seasonRepository.findById(id));
        if (season == null) {
            return 404;
        }
        seasonRepository.deleteById(id);
        return seasonRepository.findById(id).isPresent() ? 500 : 204;
    }
}
