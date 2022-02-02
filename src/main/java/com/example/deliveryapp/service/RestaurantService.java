package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {


    private RestaurantRepository restaurantRepository;
    private ReviewRepository reviewRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }

    public List<Review> getReviews(Restaurant restaurant){

        return reviewRepository.findByRestaurant(restaurant);
    }

    public Restaurant addRestaurant(Restaurant restaurant){
        return restaurantRepository.saveAndFlush(restaurant);
    }

    public void updateName(long id, String name){
        System.out.println("id service" + id + name);
        restaurantRepository.updateName(id, name);
    }

    public Optional<Restaurant> getRestaurantById(Long id){
        return restaurantRepository.findById(id);
    }

    public void deleteRestaurantById(Long id){
        restaurantRepository.deleteById(id);
    }
}

