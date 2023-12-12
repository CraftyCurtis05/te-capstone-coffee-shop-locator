package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Dislikes;
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
public class JdbcDislikesDao implements DislikesDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcDislikesDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<Dislikes> getDislikes(int userId) {
        List<Dislikes> dislikes = new ArrayList<>();
        String sql = "SELECT dislikes_id, user_id, business_id " +
                "FROM dislikes d " +
                "WHERE user_id = ? " +
                "ORDER by dislikes_id ASC;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                dislikes.add(mapRowToDislikes(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return dislikes;
    }

    @Override
    public Dislikes createDislikes(Dislikes dislikes, int userId) {
        Dislikes newDislikes = null;
        String sql = "INSERT INTO public.dislikes(dislikes_id, user_id, business_id) " +
                "VALUES (?, ?, ?) RETURNING dislikes_id;";
        try {
            int newLikesId = jdbcTemplate.queryForObject(sql, int.class, dislikes.getUserId(), dislikes.getBusinessId());

            newDislikes = getDislikesById(userId, newLikesId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newDislikes;
    }

    @Override
    public Dislikes deleteDislikes(Dislikes dislikes, int userId) {
        return null;
    }

    @Override
    public Dislikes getDislikesById(int userId, int dislikesId) {
        Dislikes dislikes = null;
        String sql = "SELECT dislikes_id, user_id, business_id " +
                "FROM dislikes " +
                "WHERE dislikes_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dislikesId, userId);
            if (results.next()) {
                dislikes = mapRowToDislikes(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return dislikes;
    }
    private Dislikes mapRowToDislikes(SqlRowSet rs) {
        Dislikes dislikes = new Dislikes();
        dislikes.setDislikesId(rs.getInt("dislikes_id"));
        dislikes.setUserId(rs.getInt("user_id"));
        dislikes.setBusinessId(rs.getInt("business_id"));
        return dislikes;
    }
}
