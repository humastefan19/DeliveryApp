package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Restaurant;

public class BeverageBuilder implements ProductBuilder {
    private final Product product;

    public BeverageBuilder() {
        this.product = new Product();
    }

    public void productName(final String name) {
        product.setName(name);
    }

    public void description(final String description) {
        product.setDescription(description);
    }

    public void weight(final String milliliters) {
        product.setWeight(milliliters + "ml");
    }

    public void price(final Double price) {
        product.setPrice(price);
    }

    public void availability(final Boolean IsAvailable) {
        product.setIsAvailable(IsAvailable);
    }

    public void salePercent(final Integer salePercent) {
        product.setSalePercentage(salePercent);
    }

    @Override
    public void restaurant(final Restaurant restaurant) {
        product.setRestaurant(restaurant);
    }

    public Product getProduct() {
        return this.product;
    }
}
