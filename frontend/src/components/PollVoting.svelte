<script>
    import { onMount } from 'svelte';
    import PollCreation from './PollCreation.svelte';

    // Variables for voting
    let polls = [];
    let selectedPoll = null;
    let selectedOption = null;

    // Fetch polls when the component is mounted
    onMount(async () => {
        await fetchPolls();
    });

    // Function to fetch polls from the backend
    async function fetchPolls() {
        try {
            const response = await fetch('http://localhost:8080/polls');
            const data = await response.json();
            console.log(data); // Check if voteOptions are included
            polls = data.map(poll => {
                return {
                    ...poll,
                    voteOptions: poll.voteOptions || [] // Ensure voteOptions is an array
                };
            });
        } catch (error) {
            console.error('Error fetching polls:', error);
        }
    }



    // Function to handle poll selection
    function selectPoll(poll) {
        selectedPoll = poll;
        selectedOption = null; // Reset the selected option
    }

    // Function to submit a vote
    async function vote() {
        if (!selectedPoll || !selectedOption) {
            alert('Please select a poll and an option.');
            return;
        }

        const voteData = {
            pollId: selectedPoll.pollId,
            optionId: selectedOption.voteOptionId
        };

        try {
            const response = await fetch('http://localhost:8080/votes', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(voteData)
            });

            if (response.ok) {
                alert('Vote submitted successfully!');
            } else {
                console.error('Failed to submit vote:', response.statusText);
            }
        } catch (error) {
            console.error('Error submitting vote:', error);
        }
    }
</script>

<div>
    <!-- Poll Creation Section -->
<!--    <PollCreation on:pollCreated={fetchPolls} />-->

    <!-- Voting Section -->
    <div>
        <h2>Vote on a Poll</h2>
        <!-- Dropdown to select a poll -->
        <select on:change="{event => selectPoll(polls[event.target.selectedIndex - 1])}">
            <option disabled selected>Select a poll</option>
            {#each polls as poll}
                <option value="{poll.pollId}">{poll.question}</option>
            {/each}
        </select>

        <!-- Display options for the selected poll -->
        {#if selectedPoll}
            <h3>{selectedPoll.question}</h3>
            {#if Array.isArray(selectedPoll.options) && selectedPoll.options.length > 0}
                {#each selectedPoll.options as option}
                    <div>
                        <input
                                type="radio"
                                bind:group={selectedOption}
                                value={option}
                                id="{option.voteOptionId}"
                        />
                        <label for="{option.voteOptionId}">{option.caption}</label>
                    </div>
                {/each}
            {:else}
                <p>No options available for this poll.</p>
            {/if}

            <button on:click={vote}>Submit Vote</button>
        {/if}

    </div>
</div>

