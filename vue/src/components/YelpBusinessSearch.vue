<template>
  <div class="coffee-shop-container">
    <h1 class="coffee-shop-title">List of local coffee shops near you:</h1>
      <div class="coffee-shop-list">
        <ul>
          <div v-for="result in results" v-bind:key="result.id">
            <div class="shop-item">
            <a class="shop-name" v-bind:href="result.url" target="_blank"> {{ result.name }} </a>
            <div class="shop-details">
            <p class="shop-address"><a href="https:www.google.com/maps/dir/?api=1" target="_blank"> {{ result.location.address1 }} </a> </p>
            <a class="shop-name" v-bind:href="result.url" target="_blank"><img class="shop-image" v-bind:src="result.image_url" /></a>
          </div>
            <button class="favorite-button" v-on:click.prevent="setFavorite(result.id)">Favorite Coffee Shop</button>
          </div>
        </div>
        </ul>
      </div>
  </div>        
</template>

<script>
import YelpService from '../services/YelpService';
import JavaService from '../services/JavaService';

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
    },
    setFavorite(value) {
      this.$store.commit('SET_FAVORITE_STATUS',  value);
      JavaService.makeFavorite({ name: 'favorite', params: { businessId: this.$store.state.id, businessName: this.$store.state.name, businessAddress: this.$store.state.location.address1 }});
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
    font-size: 30px;
    text-align: center !important;
    color: #6f6559;
  }
  .coffee-shop-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
  }
  .shop-image {
    width: 500px;
    height: auto;
    border: 3px solid #F4E2B5; 
    border-radius: 10px; 
    transition: transform 0.2s ease-in-out; 
  }
  .shop-image:hover {
    transform: scale(1.1);
  }
  .shop-name {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
    font-size: 30px; 
    font-weight: bolder;
    color: #fbfbf6; 
    margin-top: 10px; 
    background-color: #a4a49a;
    padding: 5px 10px; 
    border-radius: 10px;
  }
.shop-details {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
.favorite-button {
  margin-top: 10px;
  margin-bottom: 50px; /* Add margin at the bottom to create space */
  background-color: #F4E2B5;
  color: black;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 50px;
}
a:link, a:visited {
  color: rgb(22, 18, 18);
  text-decoration: none;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 790;
  font-size: 24px;
}
a:hover{
  color:#e8bb64;
  text-decoration: none;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-weight: 790;
  font-size: 24px;
}
  </style>