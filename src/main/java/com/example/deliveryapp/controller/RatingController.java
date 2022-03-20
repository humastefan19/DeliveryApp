package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.RatingRequest;
import com.example.deliveryapp.mapper.RatingMapper;
import com.example.deliveryapp.model.Rating;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.service.RatingService;
import com.example.deliveryapp.service.RestaurantService;
import com.example.deliveryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Validated
@RequestMapping("/ratings")
public class RatingController {

    private final RatingMapper ratingMapper;
    private final RatingService ratingService;
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final SecurityService securityService;

    public RatingController(final RatingService ratingService, final UserService userService, final RestaurantService restaurantService,
                            final RatingMapper ratingMapper, final SecurityService securityService) {
        this.ratingMapper = ratingMapper;
        this.ratingService = ratingService;
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.securityService = securityService;
    }

//    @PostMapping
//    public ResponseEntity<?> addRating(@Valid @RequestBody Rating rating){
//        Rating cat = ratingService.addRating(rating);
//        return ResponseEntity
//                .created(URI.create("/rating/" + rating.getValue())).body(cat);
//
//    }

    @PostMapping("/{restaurantId}")
    public ResponseEntity<Rating> createRating(
            @Valid
            @RequestBody
                    RatingRequest ratingRequest,
            @PathVariable
                    Long restaurantId) {
        userService.getUserById(securityService.getCurrentUserId()).ifPresent(ratingRequest::setUser);
        restaurantService.getRestaurantById(restaurantId).ifPresent(ratingRequest::setRestaurant);
        final Rating rating = ratingMapper.ratingRequestToRating(ratingRequest);
        final Rating createdRating = ratingService.addRating(rating);

        return ResponseEntity
                .created(URI.create("/rating/" + createdRating.getId()))
                .body(createdRating);
    }
}
