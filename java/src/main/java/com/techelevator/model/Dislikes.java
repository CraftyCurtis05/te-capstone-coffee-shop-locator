package com.techelevator.model;

public class Dislikes {
    private int dislikesId;
    private int userId;
    private int businessId;

    public Dislikes(int dislikesId, int userId, int businessId) {
        this.dislikesId = dislikesId;
        this.userId = userId;
        this.businessId = businessId;
    }

    public Dislikes() {
    }

    public int getDislikesId() {
        return dislikesId;
    }

    public void setDislikesId(int dislikesId) {
        this.dislikesId = dislikesId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }
}
