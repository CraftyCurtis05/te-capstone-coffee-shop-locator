<template>
  <div class="autocomplete-container" id="autocomplete-container"></div>
  <div class="autocomplete-container" id="autocomplete-container-country"></div>
  <div class="autocomplete-container" id="autocomplete-container-city"></div>
  <div id="links" class="text-center">
    <h1>Locator</h1>
    <p>Uncover your next coffee adventure. Locate the perfect brew near you</p>  
      <div class="search-bar">
        <LocatorSearchBar/>
      </div>
      <div class="list-search-results">
        <YelpBusinessSearch v-if="this.$store.state.locationID"/>
      </div>
      <div>
        <FavoritesButton/>                                         <!-- TODO: DEACTIVATED UNTIL FAVORITE BUTTON IS WORKING! -->
      </div>
    </div>
  </template>
  
  <script>
  import YelpBusinessSearch from '../components/YelpBusinessSearch.vue';
  import LocatorSearchBar from '../components/LocatorSearchBar.vue';
 // import FavoritesButton from '../components/FavoritesButton.vue'; //<!-- TODO: DEACTIVATED UNTIL FAVORITE BUTTON IS WORKING! -->

  export default {
    components: {
      YelpBusinessSearch,
      LocatorSearchBar
      //FavoritesButton                                               //<!-- TODO: DEACTIVATED UNTIL FAVORITE BUTTON IS WORKING! -->
    }
  };
  </script>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');
  
  body {
    text-align: center;
  }
  h1{
    text-align: center;
    font-family: 'Lobster Two', sans-serif;
    font-family: 'Ubuntu', sans-serif;
    font-weight: bolder;
    font-size: 35px; /* Adjust the font size as needed */
    margin: 0;
  }
  p {
    text-align: center;
    font-family: 'Lobster Two', sans-serif;
    font-family: 'Nunito Sans', sans-serif;
    font-family: 'Ubuntu', sans-serif;
    margin-top: 10px; /* Add some spacing */
  }
  .search-bar {
  margin-top: 40px; /* Adjust the margin-top value to move the search bar down */
  }
  .list-search-results img {
  width: 200px !important;
  height: auto !important;
  }
  .list-search-results img {
  width: 200px !important;
  height: auto !important;
  }
  </style>