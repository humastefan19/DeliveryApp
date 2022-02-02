package com.example.deliveryapp.model;

import com.example.deliveryapp.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@ToString
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;

    String name;
//    int locationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Product> productList;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    List<Review> reviewList;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Rating> ratingList;

//    public Restaurant(Long id, String name, int locationId) {
//        this.id = id;
//        this.name = name;
//        this.locationId = locationId;
//    }
//
//    public Restaurant(String name, int locationId) {
//        this.name = name;
//        this.locationId = locationId;
//    }

}
