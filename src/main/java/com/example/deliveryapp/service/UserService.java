package com.example.deliveryapp.service;

import com.example.deliveryapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    Optional<User> findByUsername(String username);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser (long id);

    Optional<User> getUserById(long id);
}
