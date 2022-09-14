package com.rental.carservice.service.report;

import com.rental.carservice.dto.report.ReportCreationDto;
import com.rental.carservice.dto.report.ReportDto;
import com.rental.carservice.mapper.ReportMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Report;
import com.rental.carservice.model.ReportCategory;
import com.rental.carservice.model.User;
import com.rental.carservice.repository.CarRepository;
import com.rental.carservice.repository.ReportCategoryRepository;
import com.rental.carservice.repository.ReportRepository;
import com.rental.carservice.repository.UserRepository;
import com.rental.carservice.util.ObjectValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final ReportCategoryRepository categoryRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ReportMapper reportMapper;
    private final ObjectValidation validation;
    @Override
    public List<ReportDto> getAll() {
        return reportRepository.findAll().stream()
                .map(reportMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportDto> getAll(UUID carId) {
        return reportRepository.findAllByCarId(carId).stream()
                .map(reportMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReportDto create(ReportCreationDto reportDto) {
        Report report = new Report();
        ReportCategory category = validation.getEntry(categoryRepository.findById(reportDto.getCategory()));
        Car car = validation.getEntry(carRepository.findById(reportDto.getCar()));
        User user = validation.getEntry(userRepository.findById(reportDto.getUser()));

        report.setReportCategory(category);
        report.setMessage(reportDto.getMessage());
        report.setCar(car);
        report.setUser(user);
        report.setLastUpdated(OffsetDateTime.now());

        return reportMapper.toDto(reportRepository.save(report));
    }

    @Override
    public void delete(UUID id) {
        reportRepository.deleteById(id);
    }
}
