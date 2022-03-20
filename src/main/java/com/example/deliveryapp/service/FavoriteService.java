package com.example.deliveryapp.service;

import com.example.deliveryapp.model.Favorite;
import com.example.deliveryapp.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.saveAndFlush(favorite);
    }

}
