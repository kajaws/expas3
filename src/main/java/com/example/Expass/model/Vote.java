package com.example.Expass.model;

import java.time.Instant;

public class Vote {
    private Instant publishedAt;
    private VoteOption voteOption;

    public Vote(Instant publishedAt) {

    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public VoteOption getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(VoteOption voteOption) {
        this.voteOption = voteOption;
    }
}
