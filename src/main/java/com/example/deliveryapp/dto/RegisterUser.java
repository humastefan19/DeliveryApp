package com.example.deliveryapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterUser {
    String firstName;
    String lastName;
    String address;
    String username;
    String password;

}
