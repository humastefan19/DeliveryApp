package com.example.deliveryapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String review;

    @NotNull
    private Integer rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant")
    @JsonIgnore
    private Restaurant restaurant;

}
