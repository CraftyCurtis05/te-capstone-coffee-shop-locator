package com.techelevator.dao;

import com.techelevator.model.Favorites;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.exception.DaoException;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFavoritesDao implements FavoritesDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFavoritesDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Favorites> getFavorites(int userId) {
        List<Favorites> favorites = new ArrayList<>();
        String sql = "SELECT favorites_id, user_id, business_id, business_name, business_address " +
                "FROM favorites f " +
                "WHERE user_id = ? " +
                "ORDER by favorites_id ASC;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                favorites.add(mapRowToFavorites(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return favorites;
    }

    @Override
    public Favorites createFavorites(Favorites favorites, int userId) {
        Favorites newFavorites = null;
        String sql = "INSERT INTO public.favorites(favorites_id, user_id, business_id, business_name, business_address) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING favorites_id;";
        try {
            int newFavoritesId = jdbcTemplate.queryForObject(sql, int.class, favorites.getUserId(), favorites.getBusinessId(),
                    favorites.getBusinessName(), favorites.getBusinessAddress());

            newFavorites = getFavoritesById(userId, newFavoritesId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newFavorites;
    }

    @Override
    public Favorites deleteFavorites(Favorites favorites, int userId) {
        return null;
    }

    @Override
    public Favorites getFavoritesById(int userId, int favoritesId) {
        Favorites favorites = null;
        String sql = "SELECT favorites_id, user_id, business_id, business_name, business_address " +
                "FROM favorites " +
                "WHERE favorites_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, favoritesId, userId);
            if (results.next()) {
                favorites = mapRowToFavorites(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return favorites;
    }
    private Favorites mapRowToFavorites(SqlRowSet rs) {
        Favorites favorites = new Favorites();
        favorites.setFavoriteId(rs.getInt("favorites_id"));
        favorites.setUserId(rs.getInt("user_id"));
        favorites.setBusinessId(rs.getString("business_id"));
        favorites.setBusinessName(rs.getString("business_name"));
        favorites.setBusinessAddress(rs.getString("business_address"));
        return favorites;
    }
}

