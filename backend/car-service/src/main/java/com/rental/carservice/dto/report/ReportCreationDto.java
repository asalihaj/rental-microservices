package com.rental.carservice.dto.report;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class ReportCreationDto {
    private UUID id;
    private String message;
    private UUID user;
    private UUID car;
    private UUID category;
}
