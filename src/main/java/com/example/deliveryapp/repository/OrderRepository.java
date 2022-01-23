package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.CustomerOrder;
import com.example.deliveryapp.queries.OrderQuery;
import com.example.deliveryapp.utils.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



public interface OrderRepository extends JpaRepository<CustomerOrder,Long> {
    @Modifying
    @Query(value = OrderQuery.updateStatusQuery, nativeQuery = true)
    CustomerOrder updateStatus(OrderStatus status, Long orderId);
}
