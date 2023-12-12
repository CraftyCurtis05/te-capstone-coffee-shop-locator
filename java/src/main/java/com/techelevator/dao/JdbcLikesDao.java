package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Favorites;
import com.techelevator.model.Likes;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcLikesDao implements LikesDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcLikesDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Likes> getLikes(int userId) {
        List<Likes> likes = new ArrayList<>();
        String sql = "SELECT likes_id, user_id, business_id " +
                "FROM likes l " +
                "WHERE user_id = ? " +
                "ORDER by likes_id ASC;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                likes.add(mapRowToLikes(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return likes;
    }

    @Override
    public Likes createLikes(Likes likes, int userId) {
        Likes newLikes = null;
        String sql = "INSERT INTO public.likes(likes_id, user_id, business_id) " +
                "VALUES (?, ?, ?) RETURNING likes_id;";
        try {
            int newLikesId = jdbcTemplate.queryForObject(sql, int.class, likes.getUserId(), likes.getBusinessId());

            newLikes = getLikesById(userId, newLikesId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newLikes;
    }

    @Override
    public Likes deleteLikes(Likes likes, int userId) {
        return null;
    }

    @Override
    public Likes getLikesById(int userId, int likesId) {
        Likes likes = null;
        String sql = "SELECT likes_id, user_id, business_id " +
                "FROM likes " +
                "WHERE likes_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, likesId, userId);
            if (results.next()) {
                likes = mapRowToLikes(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return likes;
    }
    private Likes mapRowToLikes(SqlRowSet rs) {
        Likes likes = new Likes();
        likes.setLikesId(rs.getInt("likes_id"));
        likes.setUserId(rs.getInt("user_id"));
        likes.setBusinessId(rs.getInt("business_id"));
        return likes;
    }
}
