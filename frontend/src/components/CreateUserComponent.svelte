<script>
    let username = "";

    // Function to handle user creation
    async function createUser() {
        if (!username) {
            alert('Please enter a username.');
            return;
        }

        const userData = {
            username: username
        };

        try {
            const response = await fetch('http://localhost:8080/users', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(userData)
            });

            if (response.ok) {
                alert('User created successfully!');
                username = ""; // Clear the input field
            } else {
                console.error('Failed to create user:', response.statusText);
            }
        } catch (error) {
            console.error('Error creating user:', error);
        }
    }
</script>

<div>
    <h2>Create User</h2>
    <label for="username">Username:</label>
    <input id="username" bind:value={username} placeholder="Enter username" />
    <button on:click={createUser}>Create User</button>
</div>
