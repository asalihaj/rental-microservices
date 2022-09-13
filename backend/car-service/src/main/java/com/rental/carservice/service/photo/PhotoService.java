package com.rental.carservice.service.photo;

import com.rental.carservice.dto.PhotoDto;

import java.util.List;
import java.util.UUID;

public interface PhotoService {
    List<PhotoDto> getAll(UUID carId);
    PhotoDto create(PhotoDto photoDto);
    int setMain(UUID photoId, UUID carId);
    void delete(UUID id);
}
