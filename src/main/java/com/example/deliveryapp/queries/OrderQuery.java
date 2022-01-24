package com.example.deliveryapp.queries;

public class OrderQuery {
    public static final String updateStatusQuery = "update customer_order o set o.status = ?1 where o.Id = ?2";
    public static final String getOrderCount = "Select count(*) from customer_order";

}
