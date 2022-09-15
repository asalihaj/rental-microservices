package com.rental.carservice.controller;

import com.rental.carservice.dto.photo.PhotoCreationDto;
import com.rental.carservice.dto.photo.PhotoDto;
import com.rental.carservice.service.photo.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/photos")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<PhotoDto>> getAllCarPhotos(@PathVariable UUID carId) {
        return new ResponseEntity<>(photoService.getAll(carId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PhotoDto> addPhoto(@RequestBody PhotoCreationDto photoDto) {
        return new ResponseEntity<>(photoService.create(photoDto), HttpStatus.OK);
    }

    @PatchMapping("/{photoId}")
    public ResponseEntity<HttpStatus> setCarMainPhoto(@PathVariable UUID photoId) {
        photoService.setMain(photoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePhoto(@PathVariable UUID id) {
        int code = photoService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }
}
