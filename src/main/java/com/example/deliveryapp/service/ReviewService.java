package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(final ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(final Review review) {
        return reviewRepository.saveAndFlush(review);
    }

}
