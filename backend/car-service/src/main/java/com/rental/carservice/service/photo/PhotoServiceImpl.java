package com.rental.carservice.service.photo;

import com.rental.carservice.dto.photo.PhotoCreationDto;
import com.rental.carservice.dto.photo.PhotoDto;
import com.rental.carservice.mapper.PhotoMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Period;
import com.rental.carservice.model.Photo;
import com.rental.carservice.repository.CarRepository;
import com.rental.carservice.repository.PhotoRepository;
import com.rental.carservice.util.CompanyData;
import com.rental.carservice.util.ObjectValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;
    private final CarRepository carRepository;
    private final CompanyData companyData;
    private final ObjectValidation validation;
    @Override
    public List<PhotoDto> getAll(UUID carId) {
        List<Car> cars = companyData.getCompanyCars(carId);
        Set<Photo> photos = new HashSet<>();

        for (Car car : cars) {
            photos.addAll(car.getPhotos());
        }

        return photos.stream()
                .map(photoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PhotoDto create(PhotoCreationDto photoDto) {
        Photo photo = new Photo();
        Car car = validation.getEntry(carRepository.findById(photoDto.getCar()));
        photo.setCar(car);
        photo.setMain(photoDto.getIsMain());
        photo.setFile(photoDto.getFile());
        photo.setLastUpdated(OffsetDateTime.now());

        if (photoDto.getIsMain()) {
            List<Photo> photos = photoRepository.findAllByCarId(photoDto.getCar());
            for (Photo p : photos) {
                p.setMain(false);
            }
            photoRepository.saveAll(photos);
        }

        return photoMapper.toDto(photoRepository.save(photo));
    }

    @Override
    public int setMain(UUID photoId) {
        Photo photo = validation.getEntry(photoRepository.findById(photoId));
        if (photo == null) {
            return 404;
        }
        if (photo.isMain()) {
            return 409;
        }
        List<Photo> photos = photoRepository.findAllByCarId(photo.getCar().getId());
        for (Photo p : photos) {
            p.setMain(p.getId().equals(photoId));
        }

        photoRepository.saveAll(photos);
        return 204;
    }

    @Override
    public int delete(UUID id) {
        Photo photo = validation.getEntry(photoRepository.findById(id));
        if (photo == null) {
            return 404;
        }
        photoRepository.deleteById(id);
        return photoRepository.findById(id).isPresent() ? 500 : 204;
    }
}
