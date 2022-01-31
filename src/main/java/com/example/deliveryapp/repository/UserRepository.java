package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.User;
import com.example.deliveryapp.queries.UserQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByUsername(String username);

    @Modifying
    @Transactional
    @Query(value = UserQuery.updateUserQuery)
    User updateUser(String fisrtName, String lastName, String username, String address, Long id);
}
