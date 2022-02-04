package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.ProductRequest;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final RestaurantService restaurantService;

    public Product productRequestToProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setRestaurant(restaurantService.getRestaurantById(productRequest.getId()).get());
        product.setName(productRequest.getName());
        product.setSalePercentage(productRequest.getSalePercentage());
        product.setIsAvailable(productRequest.getAvailable());
        product.setDescription(productRequest.getDescription());
        product.setWeight(productRequest.getWeight());
        product.setPrice(productRequest.getPrice());
        return product;
    }

}
