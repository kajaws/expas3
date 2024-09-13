package com.example.Expass.manager;

import com.example.Expass.model.Poll;
import com.example.Expass.model.User;
import com.example.Expass.model.Vote;
import com.example.Expass.model.VoteOption;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component

public class PollManager {
    private Map<UUID, User> users = new HashMap<>();
    private Map<UUID, Poll> polls = new HashMap<>();
    private Map<UUID, Vote> votes = new HashMap<>();
    private Map<UUID, VoteOption> voteOptions = new HashMap<>();

    // Methods to manage Users
    public void addUser(UUID userID, User user) {
        users.put(userID, user);
    }

    public User getUser(UUID userID) {
        return users.get(userID);
    }

    public void removeUser(UUID userID) {
        users.remove(userID);
    }

    // Methods to manage Polls
    public void addPoll(UUID pollId, Poll poll) {
        polls.put(pollId, poll);
    }

    public Poll getPoll(UUID pollId){
        return polls.get(pollId);
    }

    public void removePoll(UUID pollId) {
        polls.remove(pollId);
        votes.entrySet().removeIf(entry -> entry.getValue().getPollId().equals(pollId));
    }

    // Methods to manage Votes
    public void addVote(UUID voteId, Vote vote) {
        for (Vote existingVote : votes.values()) {
            if (existingVote.getUserId().equals(vote.getUserId()) && existingVote.getPollId().equals(vote.getPollId())) {
                existingVote.setVoteOptionId(vote.getVoteOptionId());
                existingVote.setPublishedAt(vote.getPublishedAt());
            }
        }
        votes.put(voteId, vote);
    }

    public Vote getVote(UUID voteId) {
        return votes.get(voteId);
    }

    public void removeVote(UUID voteId) {
        votes.remove(voteId);
    }

    // Methods to manage VoteOptions
    public void addVoteOption(UUID voteOptionId, VoteOption voteOption) {
        voteOptions.put(voteOptionId, voteOption);
    }

    public VoteOption getVoteOption(UUID voteOptionId) {
        return voteOptions.get(voteOptionId);
    }

    public void removeVoteOption(UUID voteOptionId) {
        voteOptions.remove(voteOptionId);
    }

    // Methods to get all Users, Polls, VoteOptions, and Votes
    public Collection<User> getUsers() {
        return users.values();
    }

    public Collection<Poll> getPolls() {
        return polls.values();
    }

    public Collection<VoteOption> getVoteOptions() {
        return voteOptions.values();
    }

    public Collection<Vote> getVotes() {
        return votes.values();
    }

    // Methods to check if a User or Poll exists
    public boolean isUserExist(UUID userId) {
        return users.containsKey(userId);
    }

    public boolean isPollExist(UUID pollId) {
        return polls.containsKey(pollId);
    }

    public Vote getVoteByUserAndPoll(UUID userId, UUID pollId) {
        for (Vote vote : votes.values()) {
            if (vote.getUserId().equals(userId) && vote.getPollId().equals(pollId)) {
                return vote;
            }
        }
        return null;
    }
}