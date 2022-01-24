package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Cart;
import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.model.Restaurant;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


public class Product implements IProduct {
    String name;
    String description;
    String weight;
    Double price;
    Boolean isAvailable;
    Integer salePercentage;


    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setWeight(String weight){
        this.weight = weight;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public void setIsAvailable(Boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public void setSalePercentage(Integer salePercentage){
        this.salePercentage = salePercentage;
    }

    @OneToMany(mappedBy = "product")
    List<Favorite> favorites;

    @OneToMany(mappedBy = "product")
    List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;
}
