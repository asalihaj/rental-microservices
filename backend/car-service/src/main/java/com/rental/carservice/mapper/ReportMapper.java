package com.rental.carservice.mapper;

import com.rental.carservice.dto.report.ReportDto;
import com.rental.carservice.model.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    @Mapping(source = "car.user.username", target = "company")
    @Mapping(source = "user.username", target = "userReport")
    @Mapping(source = "reportCategory.name", target = "category")
    ReportDto toDto(Report report);
}
