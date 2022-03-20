package com.example.deliveryapp.dto;

import com.example.deliveryapp.model.User;
import com.example.deliveryapp.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class FavoriteRequest {
    @JsonIgnore
    private User user;
    @JsonIgnore
    private Product product;


    public FavoriteRequest(final User user, final Product product) {
        this.user = user;
        this.product = product;
    }
}
