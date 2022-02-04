package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Cart;
import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
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

    @OneToMany(mappedBy = "product")
    List<Favorite> favorites;

    @OneToMany(mappedBy = "product")
    List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    Restaurant restaurant;
}
