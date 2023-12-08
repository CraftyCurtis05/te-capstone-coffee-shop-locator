<template>
  <div id="capstone-app">
    <div id="nav" v-if="!$route.meta.hideNavBar">
      <div><img class="header_pic" src="src/assets/3.png"></div>
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">HOME</router-link>
      <router-link v-bind:to="{ name: 'locator' }" v-if="$store.state.token != ''">LOCATOR</router-link>
      <router-link v-bind:to="{ name: 'links' }" v-if="$store.state.token != ''">SHOP</router-link>
      <router-link v-bind:to="{ name: 'articles' }" v-if="$store.state.token != ''">ARTICLES</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link>
      <router-link v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''"><img class="profile_pic" src="src\assets\profile.jpg"></router-link>
    </div>
    <router-view />
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

<style>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Nunito+Sans:opsz,wght@6..12,200&family=Raleway:wght@800&family=Ubuntu:wght@300&display=swap');

#nav {
  align-items: center;
  padding: 20px;
  display: flex;
  justify-content: space-between;
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Nunito Sans', sans-serif;
  font-family: 'Raleway', sans-serif;
  font-family: 'Ubuntu', sans-serif;
  font-weight: bold;
  color:black;
}
.header_pic {
  max-height: 300px;
}
.profile_pic {
  max-height: 75px;
}

</style>


