package com.example.deliveryapp.controller;
import com.example.deliveryapp.dto.RatingRequest;
import com.example.deliveryapp.mapper.RatingMapper;
import com.example.deliveryapp.model.Rating;
import com.example.deliveryapp.model.User;
import com.example.deliveryapp.service.RatingService;
import com.example.deliveryapp.service.RestaurantService;
import com.example.deliveryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@Validated
@RequestMapping("/ratings")
public class RatingController {

    private RatingMapper ratingMapper;
    private RatingService ratingService;
    private UserService userService;
    private RestaurantService restaurantService;

    public RatingController(RatingService ratingService, UserService userService, RestaurantService restaurantService,RatingMapper ratingMapper) {

        this.ratingMapper = ratingMapper;
        this.ratingService = ratingService;
        this.userService = userService;
        this.restaurantService = restaurantService;
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
                    Long restaurantId)
    {
         userService.getUserById(1).ifPresent((user) -> ratingRequest.setUser(user));
         restaurantService.getRestaurantById(restaurantId).ifPresent((restaurant) -> ratingRequest.setRestaurant(restaurant));
        Rating rating = ratingMapper.ratingRequestToRating(ratingRequest);
        Rating createdRating = ratingService.addRating(rating);

        return ResponseEntity
                .created(URI.create("/rating/" + createdRating.getId()))
                .body(createdRating);
    }
}
