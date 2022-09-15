package com.rental.carservice.controller;

import com.rental.carservice.dto.*;
import com.rental.carservice.model.FuelType;
import com.rental.carservice.service.staticdata.StaticDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/static")
@RequiredArgsConstructor
public class StaticDataController {
    private final StaticDataService dataService;

    @GetMapping("/colors")
    public ResponseEntity<List<ColorDto>> getColors() {
        return new ResponseEntity<>(dataService.getColors(), HttpStatus.OK);
    }

    @GetMapping("/fuel-types")
    public ResponseEntity<List<FuelTypeDto>> getFuelTypes() {
        return new ResponseEntity<>(dataService.getFuelTypes(), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return new ResponseEntity<>(dataService.getCategories(), HttpStatus.OK);
    }

    @GetMapping("/brands")
    public ResponseEntity<List<BrandDto>> getBrands() {
        return new ResponseEntity<>(dataService.getBrands(), HttpStatus.OK);
    }

    @GetMapping("/brands/{brandId}/models")
    public ResponseEntity<List<ModelDto>> getModels(@PathVariable UUID brandId) {
        return new ResponseEntity<>(dataService.getModels(brandId), HttpStatus.OK);
    }

    @GetMapping("/statuses")
    public ResponseEntity<List<StatusDto>> getStatuses() {
        return new ResponseEntity<>(dataService.getStatuses(), HttpStatus.OK);
    }

    @GetMapping("/utilities")
    public ResponseEntity<List<UtilityDto>> getUtilities() {
        return new ResponseEntity<>(dataService.getUtilities(), HttpStatus.OK);
    }

}
