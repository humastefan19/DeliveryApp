package com.example.deliveryapp.mapper;

import com.example.deliveryapp.model.Location;
import com.example.deliveryapp.model.product.Product;
import org.springframework.stereotype.Component;
import  com.example.deliveryapp.dto.RestaurantRequest;
import  com.example.deliveryapp.model.Restaurant;

@Component
public class RestaurantMapper {

    public Restaurant restaurantRequestToRestaurant(RestaurantRequest restaurantRequest){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantRequest.getName());
        Location location = new Location();
        location.setLatitude(restaurantRequest.getLat());
        location.setLongitude(restaurantRequest.getLongi());
        restaurant.setLocation(location);
        return restaurant;
    }
}
