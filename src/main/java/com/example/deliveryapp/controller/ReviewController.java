package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.ReviewRequest;
import com.example.deliveryapp.mapper.ReviewMapper;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.service.RestaurantService;
import com.example.deliveryapp.service.ReviewService;
import com.example.deliveryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Controller
@Validated
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final SecurityService securityService;

    public ReviewController(ReviewService reviewService, UserService userService, RestaurantService restaurantService, ReviewMapper reviewMapper, SecurityService securityService) {
        this.reviewMapper = reviewMapper;
        this.reviewService = reviewService;
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.securityService = securityService;

    }

    @PostMapping("/")
    public ResponseEntity<?> addReview(@Valid @RequestBody Review review) {
        final Review cat = reviewService.addReview(review);
        return ResponseEntity
                .created(URI.create("/review/" + review.getReview())).body(cat);

    }

    @GetMapping("/addReview/{id}")
    public String addReview(@PathVariable Long id, Model model) {
        final ReviewRequest reviewRequest = new ReviewRequest();
        model.addAttribute("review", reviewRequest);
        model.addAttribute("restaurantId", id);
        return "createReview";
    }

    @PostMapping("/{restaurantId}")
    public String createReview(
            @Valid
            @ModelAttribute("review")
                    ReviewRequest reviewRequest,
            @PathVariable
                    Long restaurantId, Model model) {
        userService.getUserById(securityService.getCurrentUserId()).ifPresent(reviewRequest::setUser);
        restaurantService.getRestaurantById(restaurantId).ifPresent(reviewRequest::setRestaurant);
        final Review review = reviewMapper.reviewRequestToReview(reviewRequest);
        final Review createdReview = reviewService.addReview(review);
        final List<Restaurant> restaurants = restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "restaurants";
    }
}
