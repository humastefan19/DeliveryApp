package com.example.deliveryapp.dto;

import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RatingRequest {
    @JsonIgnore
    private User user;
    @JsonIgnore
    private Restaurant restaurant;

    private Integer value;

    public RatingRequest(User user, Restaurant restaurant, Integer value) {
        this.user = user;
        this.restaurant = restaurant;
        this.value = value;
    }
}
