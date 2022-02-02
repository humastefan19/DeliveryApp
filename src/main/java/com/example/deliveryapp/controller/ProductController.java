package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.FavoriteRequest;
import com.example.deliveryapp.dto.ProductRequest;
import com.example.deliveryapp.mapper.FavoriteMapper;
import com.example.deliveryapp.mapper.ProductMapper;
import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.model.Rating;
import com.example.deliveryapp.model.product.*;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.service.FavoriteService;
import com.example.deliveryapp.service.ProductService;
import com.example.deliveryapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private FavoriteService favoriteService;
    private UserService userService;
    private ProductMapper productMapper;
    private FavoriteMapper favoriteMapper;

    public ProductController(ProductService productService,FavoriteService favoriteService, ProductMapper productMapper, FavoriteMapper favoriteMapper, UserService userService) {
        this.productService = productService;
        this.favoriteService = favoriteService;
        this.productMapper = productMapper;
        this.favoriteMapper = favoriteMapper;
        this.userService = userService;
    }

    @PostMapping("/addFoodProduct")
    public ResponseEntity<?> addFoodProduct(@Valid @RequestBody ProductRequest productRequest){
        Product product = productMapper.productRequestToProduct(productRequest);
        ProductBuilder foodBuilder = new FoodBuilder();
        ProductDetails processingProduct = new ProductDetails(foodBuilder);
        System.out.println(processingProduct);
        Product serviceResponse = productService.addProduct(product, processingProduct);
        return ResponseEntity
                .created(URI.create("/product/")).body(serviceResponse);
    }

    @PostMapping("/addBeverageProduct")
    public ResponseEntity<?> addBeverageProduct(@Valid @RequestBody ProductRequest productRequest){
        System.out.println(productMapper.productRequestToProduct(productRequest));
        ProductBuilder beverageBuilder = new BeverageBuilder();
        ProductDetails processingProduct = new ProductDetails(beverageBuilder);
        Product serviceResponse = productService.addProduct(productMapper.productRequestToProduct(productRequest), processingProduct);
        return ResponseEntity
                .created(URI.create("/product/")).body(serviceResponse);

    }

    @PostMapping("/{productId}/favorite")
    public ResponseEntity<?> addToFavorites( @PathVariable Long productId, @Valid @RequestBody FavoriteRequest favoriteRequest){
        userService.getUserById(1).ifPresent((user) -> favoriteRequest.setUser(user));
        productService.getProductById(productId).ifPresent((product) -> favoriteRequest.setProduct(product));
        Favorite favorite = favoriteMapper.favoriteRequestToFavorite(favoriteRequest);
        Favorite createdFavorite = favoriteService.addFavorite(favorite);

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
