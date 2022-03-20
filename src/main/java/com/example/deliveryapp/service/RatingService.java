package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Rating;
import com.example.deliveryapp.repository.RatingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(final RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Transactional
    public Rating addRating(final Rating rating) {
        return ratingRepository.saveAndFlush(rating);
    }
}
