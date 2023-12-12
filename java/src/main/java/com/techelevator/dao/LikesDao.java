package com.techelevator.dao;

import com.techelevator.model.Likes;

import java.util.List;

public interface LikesDao {
    List<Likes> getLikes(int userId);
    Likes createLikes(Likes likes, int userId);
    Likes deleteLikes(Likes likes, int userId);
    Likes getLikesById(int userId, int likesId);
}
