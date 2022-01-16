package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    Double ProductPrice;

}
