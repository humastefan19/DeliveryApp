package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.RestaurantRequest;
import com.example.deliveryapp.mapper.RestaurantMapper;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping("/get")
    public List<Restaurant> getCategories(){
        return restaurantService.getRestaurants();
    }

    @DeleteMapping("/delete")
    public void deleteRestaurantById(@RequestParam Long id) {
        restaurantService.deleteRestaurantById(id);
    }

}