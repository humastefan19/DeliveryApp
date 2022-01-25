package com.example.deliveryapp.model.product;

public class FoodBuilder implements ProductBuilder {
    private Product product;
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

    public Product getProduct(){
        return this.product;
    }
}
