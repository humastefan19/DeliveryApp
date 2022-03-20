package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Restaurant;

public class ProductDetails {
    private final ProductBuilder productBuilder;

    public ProductDetails(final ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product finalProduct() {
        return this.productBuilder.getProduct();
    }

    public void addProductDetails(String name, String weight, String description, Double price, Restaurant restaurant) {
        this.productBuilder.productName(name);
        this.productBuilder.weight(weight);
        this.productBuilder.description(description);
        this.productBuilder.availability(true);
        this.productBuilder.price(price);
        this.productBuilder.salePercent(0);
        this.productBuilder.restaurant(restaurant);
    }

}
