package com.example.deliveryapp.security;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
