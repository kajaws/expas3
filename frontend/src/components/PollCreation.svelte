<script>
    import { createEventDispatcher } from 'svelte';

    let pollQuestion = '';
    let options = [''];
    const dispatch = createEventDispatcher();

    // Function to add a new option input field
    function addOption() {
        options = [...options, ''];
    }

    // Function to handle poll creation
    async function createPoll() {
        const poll = {
            question: pollQuestion,
            options: options.filter(option => option.trim() !== '').map(optionText => ({ caption: optionText })) // Correctly map options
        };

        try {
            const response = await fetch('http://localhost:8080/polls', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(poll)
            });

            if (response.ok) {
                alert('Poll created successfully!');
                // Reset form
                pollQuestion = '';
                options = [''];
                // Dispatch an event to notify the parent component to refresh polls
                dispatch('pollCreated');
            } else {
                alert('Failed to create poll.');
            }
        } catch (error) {
            console.error('Error creating poll:', error);
        }
    }
</script>

<div>
    <h2>Create a Poll</h2>
    <div>
        <label for="pollQuestion">Poll Question:</label>
        <input type="text" bind:value={pollQuestion} id="pollQuestion" />
    </div>

    <h3>Options</h3>
    {#each options as option, index}
        <input type="text" bind:value={options[index]} placeholder="Option" />
    {/each}
    <button on:click={addOption}>Add Option</button>
    <button on:click={createPoll}>Create Poll</button>
</div>
