package com.example.deliveryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    public void updateName(long id, String name){
        System.out.println("id service" + id + name);
        restaurantRepository.updateName(id, name);
    }


    public void deleteRestaurantById(Long id){
        restaurantRepository.deleteById(id);
    }
}

