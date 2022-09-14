package com.rental.carservice.service.photo;

import com.rental.carservice.dto.photo.PhotoCreationDto;
import com.rental.carservice.dto.photo.PhotoDto;

import java.util.List;
import java.util.UUID;

public interface PhotoService {
    List<PhotoDto> getAll(UUID carId);
    PhotoDto create(PhotoCreationDto photoDto);
    void setMain(UUID photoId, UUID carId);
    void delete(UUID id);
}
