package service;

import model.Order;
import org.springframework.stereotype.Service;
import utils.OrderStatus;

@Service
public class OrderService {

    public Order updateOrderStatus(OrderStatus status, Long orderId){
        return null;
    }
}
