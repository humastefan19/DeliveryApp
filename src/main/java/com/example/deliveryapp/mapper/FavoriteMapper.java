package com.example.deliveryapp.mapper;

import com.example.deliveryapp.dto.FavoriteRequest;
import com.example.deliveryapp.model.Favorite;
import org.springframework.stereotype.Component;

@Component
public class FavoriteMapper {
    public Favorite favoriteRequestToFavorite(FavoriteRequest favoriteRequest){
        Favorite favorite = new Favorite();
        favorite.setUser(favoriteRequest.getUser());
        favorite.setProduct(favoriteRequest.getProduct());
        return favorite;
    }
}
