package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.RestaurantRequest;
import com.example.deliveryapp.mapper.RestaurantMapper;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.model.User;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.service.RestaurantService;
import com.example.deliveryapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Controller
@Validated
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private RestaurantService restaurantService;
    private UserService userService;
    private SecurityService securityService;
    private RestaurantMapper restaurantMapper;

    @GetMapping("/createRestaurant")
    public String registration(Model model) {

        model.addAttribute("restaurant", new RestaurantRequest());

        return "createRestaurant";
    }

    @PostMapping("/")
    public String addRestaurant(@Valid @ModelAttribute("restaurant") RestaurantRequest restaurantRequest, BindingResult bindingResult){
        Restaurant restaurant = restaurantMapper.restaurantRequestToRestaurant(restaurantRequest);
        Restaurant cat = restaurantService.addRestaurant(restaurant);
        return "restaurants";
    }

    @GetMapping("/{restaurantId}/reviews")
    public String getReviews( @PathVariable Long restaurantId, Model model) throws Exception {
        List<Review> reviews =  restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getReviews(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
        model.addAttribute("reviews", reviews);
        return "restaurants";
    }



    @GetMapping("/{restaurantId}/menu")
    public List<Product> getMenu(@PathVariable Long restaurantId) throws Exception {
        return restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getMenu(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
    }


    @GetMapping("/get")
    public String getRestaurants(Model model){
//        List<Review> reviews =  restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getReviews(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
//        model.addAttribute("reviews", reviews);

        List <Restaurant> restaurants =  restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "restaurants";


    }

    @GetMapping("/nearbyRestaurants")
    public String getNearbyRestaurants(Model model) throws Exception {
//        List<Review> reviews =  restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getReviews(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
//        model.addAttribute("reviews", reviews);
        List <Restaurant> restaurants =  userService.getUserById(securityService.getCurrentUserId()).map(user ->restaurantService.getNearbyRestaurants(user.getLatitude(), user.getLongitude())).orElseThrow(() -> new Exception("User not found"));
        model.addAttribute("restaurants", restaurants);
        return "restaurants";


    }



    @PutMapping("/{id}")
    public void updateRestaurantName( @PathVariable Long id, @RequestBody Restaurant restaurant){
        System.out.println("innnn!!!!" + restaurant.getName());
        restaurantService.updateName(id, restaurant.getName());
    }

    @DeleteMapping("/delete")
    public void deleteRestaurantById(@RequestParam Long id) {
        restaurantService.deleteRestaurantById(id);
    }

}
