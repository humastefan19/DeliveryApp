package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Cart;
import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.model.Restaurant;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product implements IProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
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

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @OneToMany(mappedBy = "product")
    List<Favorite> favorites;

    @OneToMany(mappedBy = "product")
    List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;
}
