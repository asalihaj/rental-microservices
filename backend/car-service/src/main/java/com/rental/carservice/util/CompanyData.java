package com.rental.carservice.util;

import com.rental.carservice.model.Car;
import com.rental.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyData {
    private final CarRepository carRepository;
    public List<Car> getCompanyCars(UUID companyId) {
        return carRepository.findAll().stream()
                .filter(car -> car.getUser().getId().equals(companyId))
                .collect(Collectors.toList());
    }
}
