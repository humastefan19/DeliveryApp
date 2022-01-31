package com.example.deliveryapp.repository.ProductRepository;

import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.model.product.ProductDetails;

public interface CustomProductRepository {
    public Product addProduct (Product product,  ProductDetails processingProduct);
}
