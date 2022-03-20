package com.example.deliveryapp.controller;

import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.model.User;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.service.FavoriteService;
import com.example.deliveryapp.service.ProductService;
import com.example.deliveryapp.service.RestaurantService;
import com.example.deliveryapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FavoriteController {

    private final ProductService productService;
    private final FavoriteService favoriteService;
    private final SecurityService securityService;
    private final UserService userService;
    private final RestaurantService restaurantService;


    @GetMapping("/addFavorites/{productId}/{restaurantId}")
    public String addFavorites(@PathVariable Long productId,@PathVariable Long restaurantId, Model model) throws Exception {
        Product product = productService.getProductById(productId).get();
        Favorite favorite = new Favorite();
        User user = userService.getUserById(securityService.getCurrentUserId()).get();
        favorite.setUser(user);
        favorite.setProduct(product);
        favoriteService.addFavorite(favorite);
        List<Product> products =  restaurantService.getRestaurantById(restaurantId).map(restaurant -> restaurantService.getMenu(restaurant)).orElseThrow(() -> new Exception("Restaurant not found"));
        model.addAttribute("products", products);
        model.addAttribute("restaurantId", restaurantId);
        return "products";
    }
}
