package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.User;
import com.example.deliveryapp.queries.UserQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByUsername(String username);

    @Modifying(flushAutomatically = true)
    @Transactional
    @Query(value = "Update User u set u.first_name =:firstName, u.last_name =:lastName, u.username =:username, u.address =:address where u.id =:id", nativeQuery = true)
    void updateUser(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("username") String username,@Param("address") String address,@Param("id") Long id);
}
