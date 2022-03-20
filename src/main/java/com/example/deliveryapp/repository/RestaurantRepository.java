package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Restaurant r SET r.name = :name WHERE r.id = :restaurantId")
    void updateName(@Param("restaurantId") long restaurantId, @Param("name") String name);
}
