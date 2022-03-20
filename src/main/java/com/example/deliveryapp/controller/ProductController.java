package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.FavoriteRequest;
import com.example.deliveryapp.dto.ProductRequest;
import com.example.deliveryapp.mapper.FavoriteMapper;
import com.example.deliveryapp.mapper.ProductMapper;
import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.model.product.*;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.service.FavoriteService;
import com.example.deliveryapp.service.ProductService;
import com.example.deliveryapp.service.RestaurantService;
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
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final FavoriteService favoriteService;
    private final UserService userService;
    private final ProductMapper productMapper;
    private final FavoriteMapper favoriteMapper;
    private final SecurityService securityService;
    private final RestaurantService restaurantService;

    public ProductController(ProductService productService, FavoriteService favoriteService, ProductMapper productMapper,
                             FavoriteMapper favoriteMapper, UserService userService, SecurityService securityService, RestaurantService restaurantService) {
        this.productService = productService;
        this.favoriteService = favoriteService;
        this.productMapper = productMapper;
        this.favoriteMapper = favoriteMapper;
        this.userService = userService;
        this.securityService = securityService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/addFood/{restaurantId}")
    public String addFood(@PathVariable Long restaurantId, Model model) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(restaurantId);
        model.addAttribute("foods", productRequest);
        return "foodProduct";
    }

    @GetMapping("/addBeverage/{restaurantId}")
    public String addBeverage(@PathVariable Long restaurantId, Model model) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setId(restaurantId);
        model.addAttribute("beverages", productRequest);
        return "beverageProduct";
    }

    @PostMapping("/addFoodProduct")
    public String addFoodProduct(@Valid @ModelAttribute("foods") ProductRequest productRequest, Model model) throws Exception {
        final Product product = productMapper.productRequestToProduct(productRequest);
        final ProductBuilder foodBuilder = new FoodBuilder();
        final ProductDetails processingProduct = new ProductDetails(foodBuilder);
//        System.out.println(processingProduct);
        Product serviceResponse = productService.addProduct(product, processingProduct);
        final List<Product> products = restaurantService.getRestaurantById(productRequest.getId())
                .map(restaurantService::getMenu)
                .orElseThrow(() -> new Exception("Restaurant not found"));
        model.addAttribute("products", products);
        return "products";
    }

    @PostMapping("/addBeverageProduct")
    public String addBeverageProduct(@Valid @ModelAttribute("beverages") ProductRequest productRequest, Model model) throws Exception {
//        System.out.println(productMapper.productRequestToProduct(productRequest));
        final ProductBuilder beverageBuilder = new BeverageBuilder();
        ProductDetails processingProduct = new ProductDetails(beverageBuilder);
        final Product serviceResponse = productService.addProduct(productMapper.productRequestToProduct(productRequest), processingProduct);
        final List<Product> products = restaurantService.getRestaurantById(productRequest.getId())
                .map(restaurantService::getMenu)
                .orElseThrow(() -> new Exception("Restaurant not found"));
        model.addAttribute("products", products);
        return "products";

    }

    @PostMapping("/{productId}/favorite")
    public ResponseEntity<?> addToFavorites(@PathVariable Long productId, @Valid @RequestBody FavoriteRequest favoriteRequest) {
        userService.getUserById(securityService.getCurrentUserId()).ifPresent(favoriteRequest::setUser);
        productService.getProductById(productId).ifPresent(favoriteRequest::setProduct);
        final Favorite favorite = favoriteMapper.favoriteRequestToFavorite(favoriteRequest);
        final Favorite createdFavorite = favoriteService.addFavorite(favorite);

        return ResponseEntity
                .created(URI.create("/favorite/" + createdFavorite.getId()))
                .body(createdFavorite);
    }

//    @GetMapping("/{restaurantId}")
//    public List<ProductOld> getMenuByRestaurant(@PathVariable Long restaurantId, @RequestBody ProductOld product){
//        System.out.println("innnn get!!!!" );
//        return productService.getMenuByRestaurant(restaurantId);
//    }

}
