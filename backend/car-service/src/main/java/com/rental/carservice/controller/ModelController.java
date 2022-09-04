package com.rental.carservice.controller;

import com.rental.carservice.dto.ModelDto;
import com.rental.carservice.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping
    public ResponseEntity<List<ModelDto>> getAll() {
        return new ResponseEntity<>(modelService.getAll(), HttpStatus.OK);
    }
}
