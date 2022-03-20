package com.example.deliveryapp.repository.ProductRepository;

import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.model.product.ProductDetails;

public interface CustomProductRepository {
    Product addProduct(final Product product, final ProductDetails processingProduct);
}
