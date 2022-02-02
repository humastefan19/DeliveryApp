package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.RatingRequest;
import com.example.deliveryapp.model.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public Rating ratingRequestToRating(RatingRequest ratingRequest){
        Rating rating = new Rating();
        rating.setValue(ratingRequest.getValue());
        rating.setUser(ratingRequest.getUser());
        rating.setRestaurant(ratingRequest.getRestaurant());
        return rating;
    }
}
