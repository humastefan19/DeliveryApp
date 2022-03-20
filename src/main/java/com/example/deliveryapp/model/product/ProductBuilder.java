package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Restaurant;

public interface ProductBuilder {

    void productName(String name);

    void description(String description);

    void weight(String weight);

    void price(Double price);

    void availability(Boolean isAvailable);

    void salePercent(Integer salePercent);

    void restaurant(Restaurant restaurant);

    Product getProduct();
}
