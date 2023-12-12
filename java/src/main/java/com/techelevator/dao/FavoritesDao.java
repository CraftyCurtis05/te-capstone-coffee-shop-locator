package com.techelevator.dao;

import com.techelevator.model.Favorites;

import java.util.List;

public interface FavoritesDao {
    List<Favorites> getFavorites(int userId);
    Favorites createFavorites(Favorites favorites, int userId);
    Favorites deleteFavorites(Favorites favorites, int userId);
    Favorites getFavoritesById(int userId, int FavoritesId);
}
