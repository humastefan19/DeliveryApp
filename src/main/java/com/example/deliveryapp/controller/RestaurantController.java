package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.RestaurantRequest;
import com.example.deliveryapp.mapper.RestaurantMapper;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.Review;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping("/restaurants")
public class RestaurantController {

    private RestaurantService restaurantService;
    private RestaurantMapper restaurantMapper;

    public RestaurantController(RestaurantService restaurantService, RestaurantMapper restaurantMapper) {
        this.restaurantService = restaurantService;
        this.restaurantMapper = restaurantMapper;
    }

    @PostMapping("/")
    public ResponseEntity<?> addRestaurant(@Valid @RequestBody RestaurantRequest restaurantRequest){
        Restaurant restaurant = restaurantMapper.restaurantRequestToRestaurant(restaurantRequest);
        Restaurant cat = restaurantService.addRestaurant(restaurant);
        return ResponseEntity
                .created(URI.create("/restaurant/" + restaurantRequest.getName())).body(cat);
    }

    @GetMapping("/{restaurantId}/reviews")
    public List<Review> getReviews( @PathVariable Long restaurantId) throws Exception {
        return restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getReviews(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
    }

    @GetMapping("/{restaurantId}/menu")
    public List<Product> getMenu(@PathVariable Long restaurantId) throws Exception {
        return restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getMenu(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
    }


    @GetMapping("/get")
    public List<Restaurant> getRestaurants(){
        return restaurantService.getRestaurants();
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
