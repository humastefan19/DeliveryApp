package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder,Long> {
//    @Modifying
//    @Query(OrderQuery.updateStatusQuery)
//    Order updateStatus(OrderStatus status, Long orderId);
}
