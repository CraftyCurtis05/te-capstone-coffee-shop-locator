<template>
  <div class="home">
    <h1>Home</h1>
    <!-- WE NEED A PARAGRAPH DESCRIBING OUR COMPANY AND WHAT WE DO -->
    <p>.........</p>
    <Carousel />
  </div>
</template>

<script>
import Carousel from '../components/Carousel.vue';
import YelpService from '../services/YelpService';

export default {
    components: { Carousel },
    created(){
      YelpService.getCoffee();
    }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');

.home {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 700px;
}

.content {
  text-align: center;
}

.content > h1 {
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Ubuntu', sans-serif;
  font-size: 24px; /* Adjust the font size as needed */
  margin: 0;
}

.content > p {
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Nunito Sans', sans-serif;
  font-family: 'Ubuntu', sans-serif;
  margin-top: 10px; /* Add some spacing */
}
</style>
