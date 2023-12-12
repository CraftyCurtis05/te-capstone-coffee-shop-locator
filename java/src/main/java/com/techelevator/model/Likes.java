package com.techelevator.model;

public class Likes {
    private int likesId;
    private int userId;
    private String businessId;

    public Likes(int likesId, int userId, String businessId) {
        this.likesId = likesId;
        this.userId = userId;
        this.businessId = businessId;
    }

    public Likes() {
    }

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
