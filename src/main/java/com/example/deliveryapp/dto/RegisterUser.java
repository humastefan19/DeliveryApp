package com.example.deliveryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUser {
    private String firstName;
    private String lastName;
    private String address;
    private String username;
    private String password;
}
