package com.example.deliveryapp.service;

import com.example.deliveryapp.model.CustomerOrder;
import com.example.deliveryapp.model.User;
import com.example.deliveryapp.repository.OrderRepository;
import com.example.deliveryapp.repository.UserRepository;
import com.example.deliveryapp.security.SecurityService;
import com.example.deliveryapp.utils.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final SecurityService securityService;
    private final UserRepository userRepository;


    public CustomerOrder updateOrderStatus(OrderStatus status, Long orderId) {
        CustomerOrder order = orderRepository.getById(orderId);
        order.setOrderStatus(status);
        return orderRepository.save(order);
    }

    public List<CustomerOrder> getOrders() {
        return orderRepository.findAll();
    }

    public List<CustomerOrder> getOrdersByCustomerId(Long userId) {
        return orderRepository.getOrderByCustomerId(userId);
    }

    public CustomerOrder getCustomerLastOrder(Long userId, OrderStatus orderStatus) {
        return orderRepository.getCurrentCustomerOrder(userId, orderStatus);
    }

    public List<CustomerOrder> getOrderByDeliveryId(Long deliveryId) {
        return orderRepository.getOrderByDeliveryId(deliveryId);
    }

    public void pickUpOder(final Long orderId) {
        CustomerOrder order = orderRepository.getById(orderId);
        final User currentUser = userRepository.getById(securityService.getCurrentUserId());
        order.setDelivery(currentUser);
        order.setOrderStatus(OrderStatus.PICKED);
        orderRepository.save(order);
    }

    public void deleteOrder(final Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public CustomerOrder getOrderById(final Long orderId) {
        return orderRepository.getById(orderId);
    }

    public void updateOrder(final CustomerOrder order) {
        CustomerOrder findOrder = orderRepository.getById(order.getId());
        findOrder.setDeliveryPrice(order.getDeliveryPrice());
        findOrder.setOrderStatus(order.getOrderStatus());
        findOrder.setTotalPrice(findOrder.getTotalProductPrice() + findOrder.getDeliveryPrice());
        orderRepository.save(findOrder);
    }

    public CustomerOrder createOrder() {
        final User currentUser = userRepository.getById(securityService.getCurrentUserId());
        CustomerOrder order = new CustomerOrder();
        order.setOrderStatus(OrderStatus.NOT_ORDER);
        order.setDeliveryPrice(5.99);
        order.setUser(currentUser);
        return orderRepository.save(order);
    }

    public CustomerOrder getCurrentOrder(final Long userId) {
        return orderRepository.getOrderByCustomerId(userId).stream()
                .filter(x -> x.getOrderStatus().equals(OrderStatus.NOT_ORDER))
                .findFirst().get();
    }

    public void sendOrder(final Long orderId) {
        CustomerOrder findOrder = orderRepository.getById(orderId);
        findOrder.setOrderStatus(OrderStatus.IN_PROCESS);
        orderRepository.save(findOrder);
    }
}
