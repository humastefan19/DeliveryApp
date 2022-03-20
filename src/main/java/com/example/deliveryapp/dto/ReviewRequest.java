package com.example.deliveryapp.dto;

import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ReviewRequest {
    @JsonIgnore
    private User user;
    @JsonIgnore
    private Restaurant restaurant;

    private String review;
    private Integer rating;


}
