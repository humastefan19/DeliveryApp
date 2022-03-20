package com.example.deliveryapp.model.product;

public interface IProduct {

    void setName(String name);

    void setDescription(String description);

    void setWeight(String weight);

    void setPrice(Double price);

    void setIsAvailable(Boolean isAvailable);

    void setSalePercentage(Integer salePercentage);
}
