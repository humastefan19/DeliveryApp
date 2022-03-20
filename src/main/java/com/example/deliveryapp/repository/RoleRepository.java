package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.Role;
import com.example.deliveryapp.queries.RoleQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query(value = RoleQuery.RoleQuery, nativeQuery = true)
    Role getByName(String name);
}
