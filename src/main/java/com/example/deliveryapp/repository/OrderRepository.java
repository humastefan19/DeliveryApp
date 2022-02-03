package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.CustomerOrder;
import com.example.deliveryapp.queries.OrderQuery;
import com.example.deliveryapp.utils.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderRepository extends JpaRepository<CustomerOrder,Long> {
    @Modifying
    @Query(value = OrderQuery.updateStatusQuery, nativeQuery = true)
    CustomerOrder updateStatus(OrderStatus status, Long orderId);

    @Query(value = "select id, delivery_price, total_price, total_product_price, order_status from customer_order where user_id =:userId", nativeQuery = true)
    List<CustomerOrder> getOrderByCustomerId(@Param("userId") Long userId);

    @Query(value = "select id from customer_order where user_id =:userId and order_status =:orderStatus", nativeQuery = true)
    CustomerOrder getCurrentCustomerOrder(@Param("userId") Long userId, @Param("orderStatus") OrderStatus orderStatus);

    @Query(value = "select id, delivery_price, total_price, total_product_price, order_status from customer_order where delivery_id =:deliveryId", nativeQuery = true)
    List<CustomerOrder> getOrderByDeliveryId(@Param("deliveryId") Long deliveryId);


}
