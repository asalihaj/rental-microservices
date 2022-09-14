package com.rental.carservice.service.review;

import com.rental.carservice.dto.review.ReviewCreationDto;
import com.rental.carservice.dto.review.ReviewDto;
import com.rental.carservice.mapper.ReviewMapper;
import com.rental.carservice.model.Car;
import com.rental.carservice.model.Review;
import com.rental.carservice.model.User;
import com.rental.carservice.repository.CarRepository;
import com.rental.carservice.repository.ReviewRepository;
import com.rental.carservice.repository.UserRepository;
import com.rental.carservice.util.ObjectValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ReviewMapper reviewMapper;
    private final ObjectValidation validation;

    @Override
    public List<ReviewDto> getAll(UUID carId) {
        return reviewRepository.findAllByCarId(carId).stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto create(ReviewCreationDto reviewDto) {
        Review review = new Review();

        Car car = validation.getEntry(carRepository.findById(reviewDto.getCar()));
        User user = validation.getEntry(userRepository.findById(reviewDto.getUser()));

        review.setStars(reviewDto.getStars());
        review.setComment(reviewDto.getComment());
        review.setCar(car);
        review.setUser(user);
        review.setLastUpdated(OffsetDateTime.now());

        return reviewMapper.toDto(reviewRepository.save(review));
    }

    @Override
    public ReviewDto edit(UUID id, ReviewDto reviewDto) {
        Optional<Review> reviewData = reviewRepository.findById(id)
                .map(review -> {
                    review.setStars(reviewDto.getStars());
                    review.setComment(reviewDto.getComment());
                    return review;
                });
        return reviewData
                .map(review -> reviewMapper.toDto(reviewRepository.save(review)))
                .orElse(null);
    }

    @Override
    public void delete(UUID id) {
        reviewRepository.deleteById(id);
    }
}
