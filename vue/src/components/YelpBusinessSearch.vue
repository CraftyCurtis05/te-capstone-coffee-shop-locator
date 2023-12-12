<template>
    <div class="coffee-shop-container">
        <h1 class="coffee-shop-title">List of local coffee shops near you:</h1>
        <div class="coffee-shop-list">
            <ul>
                <div v-for="result in results" v-bind:key="result.id">
                    <p class="shop-name"> {{ result.name }} </p>
                    <p class="shop-address"> {{ result.location.display_address }} </p>
                    <p> {{ result.url }} </p>
                    <img class="shop-image" v-bind:src="result.image_url" />
                </div>
            </ul>
        </div>
    </div>
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
<style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');
  h1.coffee-shop-title {
    font-family: 'Lobster Two', sans-serif;
    font-family: 'Ubuntu', sans-serif;
    font-weight: bolder;
    font-size: 20px;
    /* Remove margin-top to center it vertically */
    text-align: center !important;
  }
  .coffee-shop-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
  }
  /*.coffee-shop-image-container {
    text-align: center; /* Center the content horizontally
  }*/
  .shop-image {
    width: 200px;
    height: auto;
    border: 3px solid #F4E2B5; /* Add a border around the image */
    border-radius: 10px; /* Add border radius for a cute look */
    transition: transform 0.2s ease-in-out; /* Add a smooth transform transition */
  }
  /* Apply a scale transformation when hovering over the image */
  .shop-image:hover {
    transform: scale(1.1);
  }
  /* Style the coffee shop names */
  .shop-name {
    font-family: 'Your Custom Font', sans-serif; /* Change to your desired font */
    font-size: 18px; /* Adjust the font size as needed */
    color: #333; /* Change to your desired text color */
    margin-top: 10px; /* Add margin for spacing */
  }
  </style>