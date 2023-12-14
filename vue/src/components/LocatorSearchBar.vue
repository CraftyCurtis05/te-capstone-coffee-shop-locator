<template>
    <div class="location-container">
      <input type="text" v-model="locationID" name="user-location" class="location-input" placeholder="Your Location"/>
      <button v-on:click="search()" class="search-button">Search</button>
    </div>
    <div v-for="result in results" v-bind:key="result.id" class="search-result">
      <a :href="'https://www.google.com/maps/dir/?api=1&destination=' + encodeURIComponent(result.location.address1)" target="_blank" class="business-name">
        {{ result.name }}
      </a>
      <p class="business-address">
        {{ result.location.address1 }}
      </p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        locationID: ''
      };
    },
    methods: {
      search() {
        this.clearResults();
        setTimeout(() => {
        this.$store.state.locationID = this.locationID}, 500);
      },
      clearResults() {
        this.$store.state.locationID = null;
      }
    }
};
</script>

<style scoped>
  .location-container {
    display: flex;
    align-items: center;
    background-color: #F9F1DC;
    border-radius: 5px;
    padding: 10px;
    max-width: 800px;
    margin: 0 auto;
  }
  .location-input {
    flex: 1;
    padding: 10px;
    border: none;
    border-radius: 5px;
    outline: none;
  }
  .search-button {
    background-color: rgb(223, 204, 145);
    color: rgb(13, 12, 12);
  }
  .search-button {
    background-color: rgb(223, 204, 145); 
    color: rgb(13, 12, 12); 
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    margin-left: 10px;
    cursor: pointer;
  }
  .search-button:hover {
    background-color: rgb(105, 100, 100);
    color: rgb(255, 252, 251);
  }
  .search-button:hover {
    background-color: rgb(105, 100, 100); 
    color: rgb(255, 252, 251);
  }
  /* Style business names */
  .business-name {
    font-weight: bold;
    color: #333;
    font-size: 18px;
    margin-bottom: 5px;
    text-decoration: none !important; /* Add !important to override browser styles */
  }

  /* Style business addresses */
  .business-address {
    color: #666;
    font-size: 14px;
    text-decoration: none !important; /* Add !important to override browser styles */
  }
  
  </style>
  
