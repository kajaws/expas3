package com.example.Expass.model;

import java.util.UUID;

public class VoteOption {
    private String caption;
    private int presentationOrder;
    private UUID voteOptionId = UUID.randomUUID();

    public VoteOption() {}

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
}
