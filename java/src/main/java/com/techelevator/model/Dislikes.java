package com.techelevator.model;

public class Dislikes {
    private int dislikesId;
    private int userId;
    private String businessId;

    public Dislikes(int dislikesId, int userId, String businessId) {
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

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
