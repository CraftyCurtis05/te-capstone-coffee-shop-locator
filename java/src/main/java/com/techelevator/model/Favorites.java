package com.techelevator.model;

public class Favorites {
    private int favoriteId;
    private int userId;
    private String businessId;
    private String businessName;
    private String businessAddress;

    public Favorites(int favoriteId, int userId, String businessId, String businessName, String businessAddress) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.businessId = businessId;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
    }

    public Favorites() {
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }
}