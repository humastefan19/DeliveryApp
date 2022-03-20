package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.repository.ProductRepository.ProductRepository;
import com.example.deliveryapp.repository.RestaurantRepository;
import com.example.deliveryapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public RestaurantService(final RestaurantRepository restaurantRepository, final ReviewRepository reviewRepository, final ProductRepository productRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getNearbyRestaurants(final String latitude, final String longitude) {
        final double userLatitude = Math.toRadians(Double.parseDouble(latitude));
        final double userLongitude = Math.toRadians(Double.parseDouble(longitude));
        int searchedDistance = 7;
        final List<Restaurant> restaurants = restaurantRepository.findAll();
        List<Restaurant> nearbyRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            double restaurantLatitude = Math.toRadians(Double.parseDouble(restaurant.getLocation().getLatitude()));
            double restaurantLongitude = Math.toRadians(Double.parseDouble(restaurant.getLocation().getLongitude()));
            double dlon = restaurantLongitude - userLongitude;
            double dlat = restaurantLatitude - userLatitude;
            double a = Math.pow(Math.sin(dlat / 2), 2)
                    + Math.cos(userLatitude) * Math.cos(userLongitude)
                    * Math.pow(Math.sin(dlon / 2), 2);
            double c = 2 * Math.asin(Math.sqrt(a));

            // Radius of earth in kilometers
            double r = 6371;

            double distance = c * r;
            if (distance < searchedDistance) {
                nearbyRestaurants.add(restaurant);
            }
        }
        return nearbyRestaurants;
    }

    public List<Review> getReviews(final Restaurant restaurant) {
        return reviewRepository.findByRestaurant(restaurant);
    }

    public List<Product> getMenu(final Restaurant restaurant) {
        return productRepository.findByRestaurant(restaurant);
    }

    public Restaurant addRestaurant(final Restaurant restaurant) {
        return restaurantRepository.saveAndFlush(restaurant);
    }

    public void updateName(final long id, final String name) {
        System.out.println("id service" + id + name);
        restaurantRepository.updateName(id, name);
    }

    public Optional<Restaurant> getRestaurantById(final Long id) {
        return restaurantRepository.findById(id);
    }

    public void deleteRestaurantById(final Long id) {
        restaurantRepository.deleteById(id);
    }

    public Restaurant update(final Restaurant restaurant) {
        Restaurant restaurant1 = restaurantRepository.getById(restaurant.getId());
        restaurant1.setName(restaurant.getName());
        restaurant1.setLocation(restaurant.getLocation());
        return restaurantRepository.save(restaurant1);

    }
}

