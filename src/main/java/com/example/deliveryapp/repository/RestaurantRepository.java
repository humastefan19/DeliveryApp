package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
//    @Modifying
//    @Query(OrderQuery.updateStatusQuery)
//    Order updateStatus(OrderStatus status, Long orderId);
}
