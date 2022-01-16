package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;
import utils.OrderStatus;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
public class Order {
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
