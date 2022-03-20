package com.example.deliveryapp.repository.ProductRepository;

import com.example.deliveryapp.model.product.Product;
import com.example.deliveryapp.model.product.ProductDetails;
import org.springframework.stereotype.Repository;

@Repository
public class CustomProductRepositoryImplementation implements CustomProductRepository{

    @Override
    public Product addProduct(Product product,  ProductDetails processingProduct) {
        processingProduct.addProductDetails(product.getName(), product.getPrice(), product.getRestaurant());
        return product;
    }
}
