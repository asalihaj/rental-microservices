package com.rental.carservice.controller;

import com.rental.carservice.dto.review.ReviewCreationDto;
import com.rental.carservice.dto.review.ReviewDto;
import com.rental.carservice.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<ReviewDto>> getAllCarReviews(@PathVariable UUID carId) {
        return new ResponseEntity<>(reviewService.getAll(carId), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<ReviewDto>> getAllReviewsByClient(@PathVariable UUID clientId) {
        return new ResponseEntity<>(reviewService.getAllFromClient(clientId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewCreationDto reviewDto) {
        return new ResponseEntity<>(reviewService.create(reviewDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> editReview(@PathVariable UUID id, @RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(reviewService.edit(id, reviewDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable UUID id) {
        int code = reviewService.delete(id);
        return new ResponseEntity<>(HttpStatus.valueOf(code));
    }
}
