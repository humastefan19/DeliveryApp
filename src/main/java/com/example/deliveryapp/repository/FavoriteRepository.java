package com.example.deliveryapp.repository;

import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
        List<Favorite> findByProduct(Product product);
    }

