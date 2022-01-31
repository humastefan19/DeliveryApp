package com.example.deliveryapp.model;

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
    Long id;

    String name;
//    int locationId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "restaurant")
    List<ProductOld> productList;

    @OneToMany(mappedBy = "restaurant")
    List<Review> reviews;

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
