package com.example.deliveryapp.model;

import com.zaxxer.hikari.util.ClockSource;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class ProductOld {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    Double weight;
    Double price;
    String location;
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
