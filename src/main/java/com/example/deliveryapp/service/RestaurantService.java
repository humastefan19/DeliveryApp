package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.repository.ProductRepository.ProductRepository;
import com.example.deliveryapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {


    private RestaurantRepository restaurantRepository;
    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
    public List<Restaurant> getNearbyRestaurants(String latitude, String longitude){
        Double userLatitude = Math.toRadians(Double.parseDouble(latitude));
        Double userLongitude =  Math.toRadians(Double.parseDouble(longitude));
        Integer searchedDistance = 7;
        List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> nearbyRestaurants = new ArrayList<Restaurant>();
        for (Restaurant restaurant: restaurants){
            Double restaurantLatitude = Math.toRadians(Double.parseDouble(restaurant.getLocation().getLatitude()));
            Double restaurantLongitude =  Math.toRadians(Double.parseDouble(restaurant.getLocation().getLongitude()));
            double dlon = restaurantLongitude - userLongitude;
            double dlat = restaurantLatitude - userLatitude;
            double a = Math.pow(Math.sin(dlat / 2), 2)
                    + Math.cos(userLatitude) * Math.cos(userLongitude)
                    * Math.pow(Math.sin(dlon / 2),2);
            double c = 2 * Math.asin(Math.sqrt(a));

            // Radius of earth in kilometers
            double r = 6371;

            Double distance = c * r;
            if (distance < searchedDistance){
               nearbyRestaurants.add(restaurant) ;
            }
        }
        return nearbyRestaurants;
    }

    public List<Review> getReviews(Restaurant restaurant){
        return reviewRepository.findByRestaurant(restaurant);
    }

    public List<Product> getMenu(Restaurant restaurant){
        return productRepository.findByRestaurant(restaurant);
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

