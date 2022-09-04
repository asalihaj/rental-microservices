package com.rental.carservice.controller;

import com.rental.carservice.dto.CarViewDto;
import com.rental.carservice.model.Car;
import com.rental.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarViewDto>> getCars() {
        return new ResponseEntity<>(carService.getCarList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarViewDto> getCar(@PathVariable UUID id) {
        return new ResponseEntity<>(carService.getCar(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> editCar(@PathVariable UUID id, @RequestBody Car car) {
        return new ResponseEntity<>(carService.editCar(id, car), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable UUID id) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
