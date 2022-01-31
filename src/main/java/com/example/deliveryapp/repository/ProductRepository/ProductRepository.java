package com.example.deliveryapp.repository.ProductRepository;

import com.example.deliveryapp.model.Restaurant;
import com.example.deliveryapp.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product,Long> {
//    @Modifying
//    @Query(OrderQuery.updateStatusQuery)
//    Order updateStatus(OrderStatus status, Long orderId);

    @Modifying
    @Transactional
    @Query("UPDATE Restaurant r SET r.name = :name WHERE r.id = :restaurantId")
    public void updateName(@Param("restaurantId") long restaurantId, @Param("name") String name);
}
