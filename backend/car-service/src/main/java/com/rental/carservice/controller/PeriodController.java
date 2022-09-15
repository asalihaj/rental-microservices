package com.rental.carservice.controller;

import com.rental.carservice.dto.period.PeriodDto;
import com.rental.carservice.service.period.PeriodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/periods")
@RequiredArgsConstructor
public class PeriodController {
    private final PeriodService periodService;

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<PeriodDto>> getAllCompanyPeriods(@PathVariable UUID companyId) {
        return new ResponseEntity<>(periodService.getAll(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PeriodDto> createPeriod(@RequestBody PeriodDto periodDto) {
        return new ResponseEntity<>(periodService.create(periodDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodDto> editPeriod(@PathVariable UUID id, @RequestBody PeriodDto periodDto) {
        return new ResponseEntity<>(periodService.edit(id, periodDto), HttpStatus.OK);
    }

    @PostMapping("/{periodId}/add-to-group/{groupId}")
    public ResponseEntity<HttpStatus> addPeriodToGroup(@PathVariable UUID periodId, @PathVariable UUID  groupId) {
        int code = periodService.addToGroup(periodId, groupId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{periodId}/remove-from-group/{groupId}")
    public ResponseEntity<HttpStatus> removeFromGroup(@PathVariable UUID periodId, @PathVariable UUID groupId) {
        int code = periodService.removeFromGroup(periodId, groupId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePeriod(@PathVariable UUID id) {
        periodService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
