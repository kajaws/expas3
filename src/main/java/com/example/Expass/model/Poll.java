package com.example.Expass.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class Poll {
    private UUID pollId = UUID.randomUUID();
    private UUID userId;
    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private List<VoteOption> voteOption;

    public Poll() {}

    // Getters and Setters
    public UUID getPollId() {
        return pollId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public List<VoteOption> getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(List<VoteOption> voteOption) {
        this.voteOption = voteOption;
    }

}
