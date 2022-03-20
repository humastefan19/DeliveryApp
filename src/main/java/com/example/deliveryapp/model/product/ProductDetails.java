package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Restaurant;

public class ProductDetails {
    private ProductBuilder productBuilder;

    public ProductDetails(ProductBuilder productBuilder)
    {
        this.productBuilder = productBuilder;
    }

    public Product finalProduct()
    {
        return this.productBuilder.getProduct();
    }

    public void addProductDetails(String name, Double price, Restaurant restaurant)
    {

        this.productBuilder.productName(name);
        this.productBuilder.description();
        this.productBuilder.availability(true);
        this.productBuilder.price(price);
        this.productBuilder.salePercent(0);
        this.productBuilder.restaurant(restaurant);
    }

}
