package com.example.deliveryapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    String review;

    @NotNull
    Integer rating;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    @JsonIgnore
    User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant")
    @JsonIgnore
    Restaurant restaurant;

}
