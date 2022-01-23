package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.example.deliveryapp.queries.OrderQuery;
import com.example.deliveryapp.utils.OrderStatus;

public interface OrderRepository extends JpaRepository<Order,Long> {
//    @Modifying
//    @Query(OrderQuery.updateStatusQuery)
//    Order updateStatus(OrderStatus status, Long orderId);
}
