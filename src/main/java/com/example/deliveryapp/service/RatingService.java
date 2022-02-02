package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.RatingRequest;
import com.example.deliveryapp.model.Rating;
import com.example.deliveryapp.repository.RatingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Service
public class RatingService {

    RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Transactional
    public Rating addRating(Rating rating) {
        return ratingRepository.saveAndFlush(rating);
    }
}
