package com.rental.carservice.service.season;

import com.rental.carservice.dto.SeasonDto;
import com.rental.carservice.mapper.SeasonMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Season;
import com.rental.carservice.repository.CarRepository;
import com.rental.carservice.repository.SeasonRepository;
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
    private final CarRepository carRepository;
    private final SeasonMapper seasonMapper;
    private final ObjectValidation validation;
    @Override
    public List<SeasonDto> getAll(UUID companyId) {
        List<Car> cars = carRepository.findAllByUserId(companyId);
        Set<Season> seasons = new HashSet<>();

        for (Car car : cars) {
            seasons.addAll(car.getGroup().getSeasons());
        }

        return seasons.stream()
                .map(seasonMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SeasonDto create(SeasonDto seasonDto) {
        Season season = new Season();

        season.setName(seasonDto.getName());
        season.setDescription(seasonDto.getDescription());
        season.setChangeValue(seasonDto.getChangeValue());
        season.setStartDate(seasonDto.getStartDate());
        season.setEndDate(seasonDto.getEndDate());
        season.setFixed(seasonDto.getIsFixed());
        season.setLastUpdated(OffsetDateTime.now());

        return seasonMapper.toDto(seasonRepository.save(season));
    }

    @Override
    public SeasonDto edit(UUID id, SeasonDto seasonDto) {
        Optional<Season> seasonData = seasonRepository.findById(id).map(season -> {
                    String name = validation.setValue(seasonDto.getName(), season.getName());
                    String description = validation.setValue(seasonDto.getDescription(), season.getDescription());
                    int changeValue = validation.setValue(seasonDto.getChangeValue(), season.getChangeValue());
                    OffsetDateTime startDate = validation.setValue(seasonDto.getStartDate(), season.getStartDate());
                    OffsetDateTime endDate = validation.setValue(seasonDto.getEndDate(), season.getEndDate());
                    boolean isFixed = validation.setValue(seasonDto.getIsFixed(), season.isFixed());

                    season.setName(name);
                    season.setDescription(description);
                    season.setChangeValue(changeValue);
                    season.setStartDate(startDate);
                    season.setEndDate(endDate);
                    season.setFixed(isFixed);
                    season.setLastUpdated(OffsetDateTime.now());

                    return season;
                });

        return seasonData.map(seasonMapper::toDto).orElse(null);
    }

    @Override
    public void delete(UUID id) {
        seasonRepository.deleteById(id);
    }
}
