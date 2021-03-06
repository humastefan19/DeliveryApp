package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Restaurant;

public class BeverageBuilder implements ProductBuilder {
    private Product product;

    public BeverageBuilder()
    {
        this.product = new Product();
    }
    public void productName(String name){
        product.setName(name);
    }

    public void description(){
        product.setDescription("This is a beverage product");
    }

    public void weight(Integer milliliters){
        product.setWeight(milliliters + "ml");
    }

    public void price(Double price){
        product.setPrice(price);
    }

    public void availability(Boolean IsAvailable){
        product.setIsAvailable(IsAvailable);
    }

    public void salePercent(Integer salePercent){
        product.setSalePercentage(salePercent);
    }

    @Override
    public void restaurant(Restaurant restaurant) {
        product.setRestaurant(restaurant);
    }

    public Product getProduct(){
        return this.product;
    }
}
