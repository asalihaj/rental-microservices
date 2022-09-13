package com.rental.carservice.dto.car;

import com.rental.carservice.dto.group.GroupDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarDetailsDto extends CarViewDto {
    private GroupDto group;
    private BigDecimal rentalRate;
}
