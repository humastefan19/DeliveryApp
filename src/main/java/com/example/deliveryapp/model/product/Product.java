package com.example.deliveryapp.model.product;

import com.example.deliveryapp.model.Cart;
import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.model.Restaurant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Data
public class Product implements IProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String weight;
    private Double price;
    private Boolean isAvailable;
    private Integer salePercentage;

    @OneToMany(mappedBy = "product")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "product")
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
