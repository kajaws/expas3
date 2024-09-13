package com.example.Expass.model;

import java.time.Instant;
import java.util.UUID;

public class Vote {
    private Instant publishedAt;
    private UUID voteId = UUID.randomUUID();
    private UUID userId;
    private UUID voteOptionId;
    private UUID pollId;

    public Vote() {}

    // Getters and Setters

    public UUID getPollId() {
        return pollId;
    }

    public void setPollId(UUID pollId) {
        this.pollId = pollId;
    }

    public UUID getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(UUID voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getVoteId() {
        return voteId;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }
}
