package com.example.deliveryapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    private int locationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToMany(mappedBy = "restaurant")
    List<Product> productList;

    @OneToMany(mappedBy = "restaurant")
    List<Review> reviews;

    public Restaurant(Long id, String name, int locationId) {
        this.id = id;
        this.name = name;
        this.locationId = locationId;
    }

    public Restaurant(String name, int locationId) {
        this.name = name;
        this.locationId = locationId;
    }

}
