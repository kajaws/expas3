package com.example.Expass.model;


import java.util.UUID;

public class User {
    private String username;
    private String email;
    private UUID userId = UUID.randomUUID();

    public User() {}

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getUserId() {
        return userId;
    }
}


