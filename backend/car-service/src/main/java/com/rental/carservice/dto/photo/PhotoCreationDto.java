package com.rental.carservice.dto.photo;

import lombok.Data;

import java.util.UUID;

@Data
public class PhotoCreationDto extends PhotoDto {
    private UUID car;
}
