package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.CustomerOrder;
import com.example.deliveryapp.model.Role;
import com.example.deliveryapp.queries.OrderQuery;
import com.example.deliveryapp.queries.RoleQuery;
import com.example.deliveryapp.utils.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = RoleQuery.RoleQuery, nativeQuery = true)
    List<Role> getByName(String name);
}
