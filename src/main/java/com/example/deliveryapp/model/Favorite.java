package com.example.deliveryapp.model;

import com.example.deliveryapp.model.product.Product;
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
@Table(uniqueConstraints =
@UniqueConstraint(name = "UniqueProductAndUser", columnNames = { "user", "product" }))
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user")
    @JsonIgnore
    User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product")
    @JsonIgnore
    Product product;

}
