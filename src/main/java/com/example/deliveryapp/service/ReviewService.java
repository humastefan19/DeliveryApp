package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Review review) {
        return reviewRepository.saveAndFlush(review);
    }


}
