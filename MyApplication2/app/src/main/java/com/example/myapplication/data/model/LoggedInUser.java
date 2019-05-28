package com.example.myapplication.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;
    private int password;

    public LoggedInUser(String userId, String displayName,int password) {
        this.userId = userId;
        this.displayName = displayName;
        this.password =password;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getPassword(){return password;}
}
