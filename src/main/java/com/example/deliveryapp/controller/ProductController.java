package com.example.deliveryapp.controller;

import com.example.deliveryapp.dto.ProductRequest;
import com.example.deliveryapp.mapper.ProductMapper;
import com.example.deliveryapp.model.product.*;
import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.service.ProductService;
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
    private ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping("/addFoodProduct")
    public ResponseEntity<?> addFoodProduct(@Valid @RequestBody ProductRequest productRequest){
        Product product = productMapper.productRequestToProduct(productRequest);
        System.out.println("product");
        System.out.println(product.getName());
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

//    @GetMapping("/{restaurantId}")
//    public List<ProductOld> getMenuByRestaurant(@PathVariable Long restaurantId, @RequestBody ProductOld product){
//        System.out.println("innnn get!!!!" );
//        return productService.getMenuByRestaurant(restaurantId);
//    }

}
