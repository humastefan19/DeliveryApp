package com.example.deliveryapp.mapper;

import org.springframework.stereotype.Component;
import  com.example.deliveryapp.dto.RestaurantRequest;
import  com.example.deliveryapp.model.Restaurant;

@Component
public class RestaurantMapper {

    public Restaurant restaurantRequestToRestaurant(RestaurantRequest restaurantRequest){
        return new Restaurant(restaurantRequest.getName(),restaurantRequest.getLocationId());
    }
}
