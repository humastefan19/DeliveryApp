package com.example.deliveryapp.dto;

import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ReviewRequest {
    @JsonIgnore
    private User user;
    @JsonIgnore
    private Restaurant restaurant;

    private String review;
    private Integer rating;

    public ReviewRequest(User user, Restaurant restaurant, String review, Integer rating) {
        this.user = user;
        this.restaurant = restaurant;
        this.review = review;
        this.rating = rating;
    }
}
