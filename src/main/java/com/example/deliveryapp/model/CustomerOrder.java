package com.example.deliveryapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.deliveryapp.utils.OrderStatus;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    OrderStatus orderStatus;
    Double TotalPrice;
    Double DeliveryPrice;
    Double TotalProductPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "order")
    List<Cart> cartList;

}
