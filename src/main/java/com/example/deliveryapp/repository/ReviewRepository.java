package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByRestaurant(Restaurant restaurant);
}
