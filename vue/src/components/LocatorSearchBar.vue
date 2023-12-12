<template>
    <div class="location-container">
      <input type="text" v-model="locationID" name="user-location" class="location-input" placeholder="Your Location"/>
      <button v-on:click="search()" class="search-button">Search</button>
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
        this.$store.state.locationID = this.locationID;
      }
    }
<<<<<<< HEAD
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
=======
  };
  </script>
  
  <style scoped>

  .location-container {
    display: flex;
    align-items: center;
    background-color: #f9f1dc; 
    border-radius: 5px;
    padding: 10px;
    max-width: 800px; 
    margin: 0 auto; 
    
  }
  
>>>>>>> aa52bd5777900ed305745f6ccad9e0035ab75875
  .location-input {
    flex: 1;
    padding: 10px;
    border: none;
    border-radius: 5px;
    outline: none;
  }
<<<<<<< HEAD
  .search-button {
    background-color: rgb(223, 204, 145);
    color: rgb(13, 12, 12);
=======
  
  .search-button {
    background-color: rgb(223, 204, 145); 
    color: rgb(13, 12, 12); 
>>>>>>> aa52bd5777900ed305745f6ccad9e0035ab75875
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    margin-left: 10px;
    cursor: pointer;
  }
<<<<<<< HEAD
  .search-button:hover {
    background-color: rgb(105, 100, 100);
    color: rgb(255, 252, 251);
  }
  </style>
=======
  
  .search-button:hover {
    background-color: rgb(105, 100, 100); 
    color: rgb(255, 252, 251);
  }
  
  
  </style>
  
>>>>>>> aa52bd5777900ed305745f6ccad9e0035ab75875
