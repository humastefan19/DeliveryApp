package com.example.deliveryapp.service;

import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.model.product.ProductDetails;
import com.example.deliveryapp.repository.ProductRepository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(final Product product, final ProductDetails processingProduct) {
        processingProduct.addProductDetails(product.getName(), product.getWeight(), product.getDescription(), product.getPrice(), product.getRestaurant());
        return productRepository.saveAndFlush(processingProduct.finalProduct());
    }

    public Optional<Product> getProductById(final Long id) {
        return productRepository.findById(id);
    }
}
