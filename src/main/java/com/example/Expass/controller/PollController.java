package com.example.Expass.controller;

import com.example.Expass.model.Poll;
import com.example.Expass.model.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Expass.manager.PollManager;

import java.util.ArrayList;
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
        if (poll.getUserId() == null || pollManager.isUserExist(poll.getUserId())) {
            if (poll.getOptions() == null) {
                poll.setOptions(new ArrayList<>()); // Initialize options list if null
            }
            pollManager.addPoll(poll.getPollId(), poll);
            return poll;
        } else {
            throw new IllegalArgumentException("User does not exist");
        }
    }



    // Update an existing poll
    @PutMapping("/{pollId}")
    public Poll updatePoll(@PathVariable UUID pollId, @RequestBody Poll updatedPoll) {
        pollManager.addPoll(pollId, updatedPoll);
        return updatedPoll;
    }

    @PostMapping("/{pollId}/vote")
    public Poll voteOnPoll(@PathVariable UUID pollId, @RequestBody String optionId) {
        Poll poll = pollManager.getPoll(pollId);
        if (poll != null) {
            pollManager.voteOnOption(pollId, optionId);
            return pollManager.getPoll(pollId); // Return the updated poll
        } else {
            throw new IllegalArgumentException("Poll not found");
        }
    }


    // Delete a poll
    @DeleteMapping("/{pollId}")
    public ResponseEntity<String> deletePoll(@PathVariable UUID pollId) {
        pollManager.removePoll(pollId);
        return ResponseEntity.ok("Poll deleted successfully");
    }

}
