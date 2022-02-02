package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.ReviewRequest;
import com.example.deliveryapp.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    public Review reviewRequestToReview(ReviewRequest reviewRequest){
        Review review = new Review();
        review.setReview(reviewRequest.getReview());
        review.setUser(reviewRequest.getUser());
        review.setRestaurant(reviewRequest.getRestaurant());
        review.setRating(reviewRequest.getRating());
        return review;
    }
}
