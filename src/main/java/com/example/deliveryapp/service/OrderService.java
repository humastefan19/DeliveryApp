package com.example.deliveryapp.service;

import com.example.deliveryapp.model.CustomerOrder;
import org.springframework.stereotype.Service;
import com.example.deliveryapp.utils.OrderStatus;

@Service
public class OrderService {

    public CustomerOrder updateOrderStatus(OrderStatus status, Long orderId){
        return null;
    }
}
