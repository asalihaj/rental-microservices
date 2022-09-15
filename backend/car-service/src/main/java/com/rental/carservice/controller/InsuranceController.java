package com.rental.carservice.controller;

import com.rental.carservice.dto.insurance.InsuranceDto;
import com.rental.carservice.service.insurance.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/insurances")
@RequiredArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<InsuranceDto>> getAllCompanyInsurances(@PathVariable UUID companyId) {
        return new ResponseEntity<>(insuranceService.getAll(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<InsuranceDto> createInsurance(@RequestBody InsuranceDto insuranceDto) {
        return new ResponseEntity<>(insuranceService.create(insuranceDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InsuranceDto> editInsurance(@PathVariable UUID id, @RequestBody InsuranceDto insuranceDto) {
        return new ResponseEntity<>(insuranceService.edit(id, insuranceDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteInsurance(@PathVariable UUID id) {
        int code = insuranceService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }
}