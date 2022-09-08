package com.rental.carservice.controller;

import com.rental.carservice.dto.car.*;
import com.rental.carservice.model.Car;
import com.rental.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

//    @GetMapping("/orders")
//    public ResponseEntity<Object> getAvailableCars() {
//        return new ResponseEntity<>(null, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<CarViewDto>> getCars() {
        return new ResponseEntity<>(carService.getList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarViewDto> getCar(@PathVariable UUID id) {
        return new ResponseEntity<>(carService.get(id), HttpStatus.OK);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<CarViewDto>> getCompanyCars(@PathVariable UUID companyId) {
        return new ResponseEntity<>(carService.getByCompany(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CarViewDto> createCar(@RequestBody CarCreationDto car) {
        return new ResponseEntity<>(carService.create(car), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> editCar(@PathVariable UUID id, @RequestBody CarBaseDto carBaseDto) {
        return new ResponseEntity<>(carService.edit(id, carBaseDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable UUID id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
