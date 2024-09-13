package com.example.Expass.controller;

import com.example.Expass.model.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Expass.manager.PollManager;

import java.util.Collection;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollManager pollManager;

    // Fetch all polls
    @GetMapping
    public Collection<Poll> getAllPolls() {
        return pollManager.getPolls();
    }

    // Fetch a single poll by ID
    @GetMapping("/{pollId}")
    public Poll getPoll(@PathVariable UUID pollId) {
        return pollManager.getPoll(pollId);
    }

    // Create a new poll
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        if (pollManager.isUserExist(poll.getUserId())) {
            pollManager.addPoll(poll.getPollId(), poll);
            return poll;
        }
        else {
            throw new IllegalArgumentException("User does not exist");
        }
    }

    // Update an existing poll
    @PutMapping("/{pollId}")
    public Poll updatePoll(@PathVariable UUID pollId, @RequestBody Poll updatedPoll) {
        pollManager.addPoll(pollId, updatedPoll);
        return updatedPoll;
    }

    // Delete a poll
    @DeleteMapping("/{pollId}")
    public ResponseEntity<String> deletePoll(@PathVariable UUID pollId) {
        pollManager.removePoll(pollId);
        return ResponseEntity.ok("Poll deleted successfully");
    }

}
