package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Restaurant;

public interface ProductBuilder {

    public void productName(String name);

    public void description();

    public void weight(Integer weight);

    public void price(Double price);

    public void availability(Boolean isAvailable);

    public void salePercent(Integer salePercent);

    public void restaurant(Restaurant restaurant);

    public Product getProduct();
}
