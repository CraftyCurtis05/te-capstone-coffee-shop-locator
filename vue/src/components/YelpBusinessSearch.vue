<template>
    <div>
        <h1>List of local coffee shops near you:</h1>
    </div>
    <ul class="coffee-shop-list">
        <div v-for="result in results" v-bind:key="result.id">
            <p> {{ result.name }} </p>
            <p> {{ result.location.display_address }} </p>
            <p> {{ result.url }} </p>
            <img v-bind:src="result.image_url" />
        </div>
    </ul>
</template>

<script>
    import YelpService from '../services/YelpService';

    export default {
        data() {
            return { 
                results: [],
                locationID: ''
            }
        },
        methods: {
            getResults(locationID) {
                YelpService.getCoffee(locationID)
                .then(response => {
                    this.results = response.data.businesses;
                    console.log(this.results);
                })
                .catch(error => {
                    console.log(error);
                })
            }
        },
        created() {
            this.getResults(this.$store.state.locationID);
        }
    }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');

h1 {
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Ubuntu', sans-serif;
  font-weight: bolder;
  font-size: 20px; /* Adjust the font size as needed */
  text-align: center;
  margin: 0;
}
</style>