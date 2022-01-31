package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.ProductRequest;
import com.example.deliveryapp.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product productRequestToProduct(ProductRequest productRequest){
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setSalePercentage(productRequest.getSalePercentage());
        product.setIsAvailable(productRequest.getAvailable());
        product.setDescription(productRequest.getDescription());
        product.setWeight(productRequest.getWeight());
        product.setPrice(productRequest.getPrice());
        return product;
    }
}
