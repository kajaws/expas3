<script>
    import CreateUserComponent from './components/CreateUserComponent.svelte';
    import CreatePollComponent from './components/PollCreation.svelte';
    import VoteComponent from './components/PollVoting.svelte';
    import './app.css'
</script>

<main>
    <CreateUserComponent />
    <CreatePollComponent />
    <VoteComponent />
</main>
