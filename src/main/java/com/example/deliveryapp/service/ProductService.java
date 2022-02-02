package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.product.BeverageBuilder;
import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.model.product.ProductBuilder;
import com.example.deliveryapp.model.product.ProductDetails;
import com.example.deliveryapp.repository.ProductRepository.ProductRepository;
import com.example.deliveryapp.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product, ProductDetails processingProduct){
        processingProduct.addProductDetails(product.getName(), product.getPrice());
        return productRepository.saveAndFlush(processingProduct.finalProduct());
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }
}
