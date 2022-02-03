package com.example.deliveryapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.deliveryapp.utils.Roles;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String address;
    String username;
    String password;
    Roles role;
    @Transient
    private String passwordConfirm;

    @OneToMany(mappedBy = "user")
    List<CustomerOrder> orderList;

    @OneToMany(mappedBy = "user")
    List<CustomerOrder> deliveryOrderList;

    @OneToMany(mappedBy = "user")
    List<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    List<Review> reviews;

    @ManyToMany
    private Set<Role> roles;

}
