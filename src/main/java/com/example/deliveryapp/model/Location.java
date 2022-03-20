package com.example.deliveryapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "location")
    private Restaurant restaurant;
    private String latitude;
    private String longitude;
}
