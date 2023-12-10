<template>
  <div id="favorites" class="text-center">
    <h1>Favorites</h1> 
    <!-- WE NEED A PARAGRAPH DESCRIBING WHAT THIS PAGE IS -->
    <p>.........</p>       
  </div>
</template>

<script>
export default {
  computed: {
    notification() {
      return this.$store.state.notification;
    },
    notificationClass() {
      return {
        'status-message': true,
        error: this.notification?.type?.toLowerCase() === 'error',
        success: this.notification?.type?.toLowerCase() === 'success'
      };
    }
  },
  methods: {
    clearNotification() {
      this.$store.commit('CLEAR_NOTIFICATION');
    }
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');
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
</style>