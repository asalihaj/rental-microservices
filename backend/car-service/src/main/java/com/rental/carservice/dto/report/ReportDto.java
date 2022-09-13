package com.rental.carservice.dto.report;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class ReportDto extends ReportCreationDto {
    private UUID id;
    private String message;
    private String company;
    private String userReport;
    private String category;
    private OffsetDateTime lastUpdated;
}
