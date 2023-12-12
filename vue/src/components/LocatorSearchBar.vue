<template>
    <div class="location-container">
        <input type="text" v-model="locationID" name="user-location" placeholder="Your Location"/>
        <button v-on:click="search()">Search</button>
    </div>
</template>

<script>
export default {
    data () {
        return { 
            locationID: ''
        };
    },
    methods: {
        search() {
            this.$store.state.locationID = this.locationID;
        }
    }
};
</script>