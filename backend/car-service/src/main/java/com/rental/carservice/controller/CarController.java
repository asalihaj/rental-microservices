package com.rental.carservice.controller;

import com.rental.carservice.dto.ColorDto;
import com.rental.carservice.dto.car.*;
import com.rental.carservice.service.car.CarService;
import com.rental.carservice.util.DateConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    @GetMapping("/from/{rentalDate}/to/{returnDate}")
    public ResponseEntity<Object> getAvailableCars(@PathVariable String rentalDate, @PathVariable String returnDate) {
        OffsetDateTime rentalDay = DateConverter.toDate(rentalDate);
        OffsetDateTime returnDay = DateConverter.toDate(returnDate);
        return new ResponseEntity<>(carService.getAvailableCars(rentalDay, returnDay), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarViewDto>> getCars() {
        return new ResponseEntity<>(carService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarViewDto> getCar(@PathVariable UUID id) {
        return new ResponseEntity<>(carService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity<List<CarViewDto>> getCompanyCars(@PathVariable UUID companyId) {
        return new ResponseEntity<>(carService.getByCompany(companyId), HttpStatus.OK);
    }

    @GetMapping("/colors")
    public ResponseEntity<List<ColorDto>> getColors() {
        return new ResponseEntity<>(null);
    }

    @PostMapping
    public ResponseEntity<CarViewDto> createCar(@RequestBody CarCreationDto car) {
        return new ResponseEntity<>(carService.create(car), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDetailsDto> editCar(@PathVariable UUID id, @RequestBody CarBaseDto carBaseDto) {
        return new ResponseEntity<>(carService.edit(id, carBaseDto), HttpStatus.OK);
    }

    @PostMapping("/{carId}/add-utility/{utilityId}")
    public ResponseEntity<HttpStatus> addUtility(@PathVariable UUID carId, @PathVariable UUID utilityId) {
        int code = carService.addUtility(carId, utilityId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @PostMapping("/{carId}/add-insurance/{insuranceId}")
    public ResponseEntity<HttpStatus> addInsurance(@PathVariable UUID carId, @PathVariable UUID insuranceId) {
        int code = carService.addInsurance(carId, insuranceId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{carId}/remove-utility/{utilityId}")
    public ResponseEntity<HttpStatus> removeUtility(@PathVariable UUID carId, @PathVariable UUID utilityId) {
        int code = carService.removeUtility(carId, utilityId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{carId}/remove-insurance/{insuranceId}")
    public ResponseEntity<HttpStatus> removeInsurance(@PathVariable UUID carId, @PathVariable UUID insuranceId) {
        int code = carService.removeInsurance(carId, insuranceId);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable UUID id) {
        carService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
