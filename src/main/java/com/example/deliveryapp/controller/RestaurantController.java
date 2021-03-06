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
import java.util.Optional;

@Controller
@Validated
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;
    private final SecurityService securityService;
    private final RestaurantMapper restaurantMapper;

    @GetMapping("/createRestaurant")
    public String registration(Model model) {

        model.addAttribute("restaurant", new RestaurantRequest());

        return "createRestaurant";
    }

    @PostMapping("/")
    public String addRestaurant(@Valid @ModelAttribute("restaurant") RestaurantRequest restaurantRequest, BindingResult bindingResult,Model model){
        Restaurant restaurant = restaurantMapper.restaurantRequestToRestaurant(restaurantRequest);
        Restaurant cat = restaurantService.addRestaurant(restaurant);
        List <Restaurant> restaurants =  restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "restaurants";
    }

    @GetMapping("/{restaurantId}/reviews")
    public String getReviews( @PathVariable Long restaurantId, Model model) throws Exception {
        List<Review> reviews =  restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getReviews(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
        model.addAttribute("reviews", reviews);
        return "restaurants";
    }



    @GetMapping("/{restaurantId}/menu")
    public String getMenu(@PathVariable Long restaurantId, Model model) throws Exception {
        List<Product> products =  restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getMenu(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
        model.addAttribute("products", products);
        model.addAttribute("restaurantId", restaurantId);
        return "products";
    }


    @GetMapping("/get")
    public String getRestaurants(Model model){
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

    @GetMapping("/edit/{id}")
    public String getRestaurantForEdit(@PathVariable Long id, Model model){
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        RestaurantRequest restaurantRequest = restaurantMapper.restaurantToRestaurantRequest(restaurant.get());
        model.addAttribute("restaurant", restaurantRequest);
        return "editRestaurant";
    }

    @PostMapping("/performEdit")
    public String performEdit(@Valid @ModelAttribute("restaurant") RestaurantRequest restaurantRequest, BindingResult bindingResult,Model model){
        Restaurant restaurant = restaurantMapper.restaurantRequestToRestaurant(restaurantRequest);
        restaurantService.update(restaurant);
        List <Restaurant> restaurants =  restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "restaurants";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        restaurantService.deleteRestaurantById(id);
        List <Restaurant> restaurants =  restaurantService.getRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "restaurants";
    }
}
