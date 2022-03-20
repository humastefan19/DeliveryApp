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


    @Query(value = "select c from CustomerOrder c where c.user.id =:userId")
    List<CustomerOrder> getOrderByCustomerId(@Param("userId") Long userId);

    @Query(value = "select id from customer_order where user_id =:userId and order_status =:orderStatus", nativeQuery = true)
    CustomerOrder getCurrentCustomerOrder(@Param("userId") Long userId, @Param("orderStatus") OrderStatus orderStatus);

    @Query("select c from CustomerOrder c where c.delivery.id =:deliveryId")
    List<CustomerOrder> getOrderByDeliveryId(@Param("deliveryId") Long deliveryId);


}
