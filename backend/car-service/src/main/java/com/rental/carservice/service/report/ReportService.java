package com.rental.carservice.service.report;

import com.rental.carservice.dto.report.ReportCreationDto;
import com.rental.carservice.dto.report.ReportDto;

import java.util.List;
import java.util.UUID;

public interface ReportService {
    List<ReportDto> getAll();
    List<ReportDto> getAll(UUID carId);
    ReportDto create(ReportCreationDto reportDto);
    void delete(UUID id);
}
