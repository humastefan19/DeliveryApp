package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Restaurant;

public class FoodBuilder implements ProductBuilder {
    private Product product;

    public FoodBuilder()
    {
        this.product = new Product();
    }

    public void productName(String name){
       product.setName(name);
    }

    public void description(){
        product.setDescription("This is a food product");
    }

    public void weight(Integer grams){
        product.setWeight(grams + "g");
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
