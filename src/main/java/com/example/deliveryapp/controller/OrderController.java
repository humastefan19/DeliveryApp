package com.example.deliveryapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/order")
    public String getAllOrders(){
        return "Hello world!";
    }

}
