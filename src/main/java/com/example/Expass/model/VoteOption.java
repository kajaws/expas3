package com.example.Expass.model;

import java.util.UUID;

public class VoteOption {
    private String caption;
    private int presentationOrder;
    private UUID voteOptionId = UUID.randomUUID();
    private int voteCount; // Move this to the top with other fields

    // No-argument constructor
    public VoteOption() {
        this.voteCount = 0; // Initialize to default value
        this.presentationOrder = 0; // Optional: Initialize if needed
    }

    // Getters and Setters
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getPresentationOrder() {
        return presentationOrder;
    }

    public void setPresentationOrder(int presentationOrder) {
        this.presentationOrder = presentationOrder;
    }

    public UUID getVoteOptionId() {
        return voteOptionId;
    }

    // Optional: Add setter for voteOptionId if you need to modify it
    public void setVoteOptionId(UUID voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    // Increment vote count
    public void incrementVoteCount() {
        this.voteCount++;
    }
}

