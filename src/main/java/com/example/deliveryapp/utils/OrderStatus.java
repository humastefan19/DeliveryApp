package com.example.deliveryapp.utils;

public enum OrderStatus {
    NOT_ORDER("NOT_ORDER"),
    IN_PROCESS("IN_PROCESS"),
    PICKED("PICKED"),
    ON_ROUTE("ON_ROUTE"),
    DELIVERED("DELIVERED");

    private final String message;

    OrderStatus(String message) {
        this.message = message;
    }
}
