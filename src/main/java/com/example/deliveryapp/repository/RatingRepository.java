package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository  extends JpaRepository<Rating,Long> {
}
