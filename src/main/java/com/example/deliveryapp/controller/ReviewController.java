package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.ReviewRequest;
import com.example.deliveryapp.mapper.RatingMapper;
import com.example.deliveryapp.mapper.ReviewMapper;
import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.service.RestaurantService;
import com.example.deliveryapp.service.ReviewService;
import com.example.deliveryapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.Authenticator;
import java.net.URI;
import java.security.Principal;

@RestController
@Validated
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewMapper reviewMapper;
    private ReviewService reviewService;
    private UserService userService;
    private RestaurantService restaurantService;
    private SecurityService securityService;

    public ReviewController(ReviewService reviewService, UserService userService,RestaurantService restaurantService,  ReviewMapper reviewMapper, SecurityService securityService) {
        this.reviewMapper = reviewMapper;
        this.reviewService = reviewService;
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.securityService = securityService;

    }

    @PostMapping("/")
    public ResponseEntity<?> addReview(@Valid @RequestBody Review review){
        Review cat = reviewService.addReview(review);
        return ResponseEntity
                .created(URI.create("/review/" + review.getReview())).body(cat);

    }
    @PostMapping("/{restaurantId}")
    public ResponseEntity<Review> createReview(
            @Valid
            @RequestBody
                    ReviewRequest reviewRequest,
            @PathVariable
                    Long restaurantId)
    {
        userService.getUserById(securityService.getCurrentUserId()).ifPresent((user) -> reviewRequest.setUser(user));
        restaurantService.getRestaurantById(restaurantId).ifPresent((restaurant) -> reviewRequest.setRestaurant(restaurant));
        Review review = reviewMapper.reviewRequestToReview(reviewRequest);
        Review createdReview = reviewService.addReview(review);

        return ResponseEntity
                .created(URI.create("/review/" + createdReview.getId()))
                .body(createdReview);
    }
}
