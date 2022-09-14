package com.rental.carservice.service.insurance;

import com.rental.carservice.dto.InsuranceDto;
import com.rental.carservice.mapper.InsuranceMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Insurance;
import com.rental.carservice.repository.InsuranceRepository;
import com.rental.carservice.util.CompanyData;
import com.rental.carservice.util.ObjectValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper insuranceMapper;
    private final CompanyData companyData;
    private final ObjectValidation validation;
    @Override
    public List<InsuranceDto> getAll(UUID companyId) {
        List<Car> cars = companyData.getCompanyCars(companyId);
        Set<Insurance> insurances = new HashSet<>();

        for (Car car : cars) {
            insurances.addAll(car.getInsurances());
        }

        return insurances.stream()
                .map(insuranceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public InsuranceDto create(InsuranceDto insuranceDto) {
        Insurance insurance = new Insurance();

        insurance.setName(insuranceDto.getName());
        insurance.setCoverValue(insuranceDto.getCoverValue());
        insurance.setFixed(insuranceDto.getIsFixed());
        insurance.setPrice(insuranceDto.getPrice());
        insurance.setLastUpdated(OffsetDateTime.now());

        return insuranceMapper.toDto(insuranceRepository.save(insurance));
    }

    @Override
    public InsuranceDto edit(UUID id, InsuranceDto insuranceDto) {
        Optional<Insurance> insuranceData = insuranceRepository.findById(id).map(insurance -> {
            String name = validation.setValue(insuranceDto.getName(), insurance.getName());
            int coverValue = validation.setValue(insuranceDto.getCoverValue(), insurance.getCoverValue());
            boolean isFixed = validation.setValue(insuranceDto.getIsFixed(), insurance.isFixed());
            BigDecimal price = validation.setValue(insuranceDto.getPrice(), insurance.getPrice());

            insurance.setName(name);
            insurance.setCoverValue(coverValue);
            insurance.setFixed(isFixed);
            insurance.setPrice(price);
            insurance.setLastUpdated(OffsetDateTime.now());

            return insurance;
        });
        return insuranceData.map(insuranceMapper::toDto).orElse(null);
    }

    @Override
    public void delete(UUID id) {
        insuranceRepository.deleteById(id);
    }
}
