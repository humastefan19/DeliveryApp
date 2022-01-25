package com.example.deliveryapp.model.product;

public interface ProductBuilder {

    public void productName(String name);

    public void description();

    public void weight(Integer weight);

    public void price(Double price);

    public void availability(Boolean isAvailable);

    public void salePercent(Integer salePercent);

    public Product getProduct();
}
