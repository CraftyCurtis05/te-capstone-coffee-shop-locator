package com.techelevator.model;

public class Favorites {
    private int favoriteId;
    private int userId;
    private int businessId;
    private String businessName;
    private String businessAddress;

    public Favorites(int favoriteId, int userId, int businessId, String businessName, String businessAddress) {
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

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
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