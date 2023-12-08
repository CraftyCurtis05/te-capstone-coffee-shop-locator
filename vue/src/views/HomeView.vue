<template>
  <div class="home">
    <h1>Home</h1>
    <p>This page IS working</p>
    <Carousel />
  </div>
</template>

<script>
import Carousel from '../components/Carousel.vue';

export default {
    components: { Carousel }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');

.home > h1{
 font-family: 'Lobster Two', sans-serif;
  font-family: 'Ubuntu', sans-serif;
}
.home > p{
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Nunito Sans', sans-serif;
  font-family: 'Ubuntu', sans-serif;
}
</style>
