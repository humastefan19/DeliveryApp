package com.example.deliveryapp.service;

import com.example.deliveryapp.model.User;

import java.util.Optional;

public interface UserService {
    void save(User user);

    Optional<User> findByUsername(String username);
}
