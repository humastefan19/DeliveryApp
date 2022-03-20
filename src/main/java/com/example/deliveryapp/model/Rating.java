package com.example.deliveryapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Data
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Min(1)
    @Max(10)
    private  Integer value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    @JsonIgnore
    private   User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant")
    @JsonIgnore
    private Restaurant restaurant;

}