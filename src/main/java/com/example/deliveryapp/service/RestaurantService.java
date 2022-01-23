package com.example.deliveryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.repository.RestaurantRepository;

import java.util.List;
@Service
public class RestaurantService {


    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }

    public Restaurant addRestaurant(Restaurant restaurant){
        return restaurantRepository.saveAndFlush(restaurant);
    }

    public void deleteRestaurantById(Long id){
        restaurantRepository.deleteById(id);
    }
}

