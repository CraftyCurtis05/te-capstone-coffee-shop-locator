package com.techelevator.dao;

import com.techelevator.model.Dislikes;

import java.util.List;

public interface DislikesDao {
    List<Dislikes> getDislikes(int userId);
    Dislikes createDislikes(Dislikes dislikes, int userId);
    Dislikes deleteDislikes(Dislikes dislikes, int userId);
    Dislikes getDislikesById(int userId, int dislikesId);
}