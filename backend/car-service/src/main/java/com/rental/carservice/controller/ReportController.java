package com.rental.carservice.controller;

import com.rental.carservice.dto.report.ReportCreationDto;
import com.rental.carservice.dto.report.ReportDto;
import com.rental.carservice.service.report.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public ResponseEntity<List<ReportDto>> getAll() {
        return new ResponseEntity<>(reportService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<ReportDto>> getAllCarReports(@PathVariable UUID carId) {
        return new ResponseEntity<>(reportService.getAll(carId), HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<HttpStatus> getReportCategories() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReportDto> createReport(@RequestBody ReportCreationDto reportDto) {
        return new ResponseEntity<>(reportService.create(reportDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReport(@PathVariable UUID id) {
        int code = reportService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }
}
