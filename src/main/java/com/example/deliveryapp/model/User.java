package com.example.deliveryapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.deliveryapp.utils.Roles;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    Roles role;

//    @OneToMany(mappedBy = "user")
//    List<Order> orderList;

    @OneToMany(mappedBy = "user")
    List<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    List<Review> reviews;

}
