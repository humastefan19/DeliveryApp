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
    private Long id;

    private OrderStatus orderStatus;
    private Double TotalPrice;
    private Double DeliveryPrice;
    private Double TotalProductPrice;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private User delivery;

    @OneToMany(mappedBy = "order")
    private List<Cart> cartList;

}
