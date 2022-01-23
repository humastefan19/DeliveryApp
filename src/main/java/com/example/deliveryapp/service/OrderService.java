package com.example.deliveryapp.service;

import com.example.deliveryapp.model.CustomerOrder;
import com.example.deliveryapp.repository.OrderRepository;
import org.springframework.stereotype.Service;
import com.example.deliveryapp.utils.OrderStatus;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService (OrderRepository _orderRepository){
        orderRepository = _orderRepository;
    }

    public CustomerOrder updateOrderStatus(OrderStatus status, Long orderId){
        return orderRepository.updateStatus(status,orderId);
    }
}
