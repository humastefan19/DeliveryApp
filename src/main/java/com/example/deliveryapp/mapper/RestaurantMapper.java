package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.RestaurantRequest;
import com.example.deliveryapp.model.Location;
import com.example.deliveryapp.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

    public Restaurant restaurantRequestToRestaurant(final RestaurantRequest restaurantRequest) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantRequest.getId());
        restaurant.setName(restaurantRequest.getName());
        Location location = new Location();
        location.setLatitude(restaurantRequest.getLat());
        location.setLongitude(restaurantRequest.getLongi());
        restaurant.setLocation(location);
        return restaurant;
    }

    public RestaurantRequest restaurantToRestaurantRequest(final Restaurant restaurant) {
        RestaurantRequest restaurantRequest = new RestaurantRequest();
        restaurantRequest.setId(restaurant.getId());
        restaurantRequest.setName(restaurant.getName());
        restaurantRequest.setLat(restaurant.getLocation().getLatitude());
        restaurantRequest.setLongi(restaurant.getLocation().getLongitude());
        return restaurantRequest;
    }
}
