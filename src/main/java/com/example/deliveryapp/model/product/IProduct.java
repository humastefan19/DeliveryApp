package com.example.deliveryapp.model.product;

public interface IProduct {

    public void setName(String name);

    public void setDescription(String description);

    public void setWeight(String weight);

    public void setPrice(Double price);

    public void setIsAvailable(Boolean isAvailable);

    public void setSalePercentage(Integer salePercentage);
}
