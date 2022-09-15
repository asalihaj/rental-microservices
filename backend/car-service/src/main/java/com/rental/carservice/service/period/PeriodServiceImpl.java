package com.rental.carservice.service.period;

import com.rental.carservice.dto.period.PeriodDto;
import com.rental.carservice.mapper.PeriodMapper;
import com.rental.carservice.model.Group;
import com.rental.carservice.model.Period;
import com.rental.carservice.repository.GroupRepository;
import com.rental.carservice.repository.PeriodRepository;
import com.rental.carservice.util.CompanyData;
import com.rental.carservice.util.ObjectValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PeriodServiceImpl implements PeriodService {
    private final PeriodRepository periodRepository;
    private final GroupRepository groupRepository;
    private final PeriodMapper periodMapper;
    private final ObjectValidation validation;
    private final CompanyData companyData;
    @Override
    public List<PeriodDto> getAll(UUID companyId) {
        return periodRepository.findAllByCompanyId(companyId)
                .stream().map(periodMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PeriodDto create(PeriodDto periodDto) {
        Period period = new Period();

        period.setName(periodDto.getName());
        period.setChangeValue(periodDto.getChangeValue());
        period.setFixed(periodDto.getIsFixed());
        period.setStartDay(periodDto.getStartDay());
        period.setEndDay(periodDto.getEndDay());
        period.setLastUpdated(OffsetDateTime.now());

        return periodMapper.toDto(periodRepository.save(period));
    }

    @Override
    public PeriodDto edit(UUID id, PeriodDto periodDto) {
        Optional<Period> periodData = periodRepository.findById(id).map(period -> {
            String name = validation.setValue(periodDto.getName(), period.getName());
            short startDay = validation.setValue(periodDto.getStartDay(), period.getStartDay());
            short endDay = validation.setValue(periodDto.getEndDay(), period.getEndDay());
            int changeValue = validation.setValue(periodDto.getChangeValue(), period.getChangeValue());
            boolean isFixed = validation.setValue(periodDto.getIsFixed(), period.isFixed());

            period.setName(name);
            period.setStartDay(startDay);
            period.setEndDay(endDay);
            period.setChangeValue(changeValue);
            period.setFixed(isFixed);
            period.setLastUpdated(OffsetDateTime.now());

            return periodRepository.save(period);
        });
        return periodData.map(periodMapper::toDto).orElse(null);
    }

    @Override
    public int addToGroup(UUID periodId, UUID groupId) {
        Period period = validation.getEntry(periodRepository.findById(periodId));
        Group group = validation.getEntry(groupRepository.findById(groupId));
        if (period != null && group != null) {
            boolean isAdded = group.getPeriods().add(period);
            if (!isAdded) {
                return 409;
            }
            groupRepository.save(group);
            return 204;
        }
        return 404;
    }

    @Override
    public int removeFromGroup(UUID periodId, UUID groupId) {
        Period period = validation.getEntry(periodRepository.findById(periodId));
        Group group = validation.getEntry(groupRepository.findById(groupId));
        if (period != null && group != null) {
            boolean isRemoved = group.getPeriods().remove(period);
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
        Period period = validation.getEntry(periodRepository.findById(id));
        if (period == null) {
            return 404;
        }
        periodRepository.deleteById(id);
        return periodRepository.findById(id).isPresent() ? 500 : 204;
    }
}
