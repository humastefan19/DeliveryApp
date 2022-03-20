package com.example.deliveryapp.controller;

import com.example.deliveryapp.model.Cart;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.service.CartService;
import com.example.deliveryapp.service.OrderService;
import com.example.deliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final RestaurantService restaurantService;
    private final OrderService orderService;

    @GetMapping("/addToCart/{id}/{restaurantId}")
    public String addToCart(@PathVariable Long id, @PathVariable Long restaurantId, Model model) throws Exception {
        Cart cart = cartService.addProductToCart(id);
        final List<Product> products = restaurantService.getRestaurantById(restaurantId)
                .map(restaurantService::getMenu)
                .orElseThrow(() -> new Exception("Restaurant not found"));
        model.addAttribute("products", products);
        model.addAttribute("restaurantId", restaurantId);
        return "products";
    }
}
