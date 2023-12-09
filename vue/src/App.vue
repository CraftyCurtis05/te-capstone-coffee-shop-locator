<template>
  <div id="capstone-app">
    <div id="nav" v-if="!$route.meta.hideNavBar">
      <div class="header-pic-container">
        <div><img class="header-pic" src="src\assets\MagicEraser_231208_090204.PNG"></div>
      </div>
      <div class="logo-name-container">
        <div class="company-name">JOlt</div>
      </div>
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">HOME</router-link>
      <div class="separators"></div>
      <router-link v-bind:to="{ name: 'locator' }" v-if="$store.state.token != ''">LOCATOR</router-link>
      <div class="separators"></div>
      <router-link v-bind:to="{ name: 'links' }" v-if="$store.state.token != ''">SHOP</router-link>
      <div class="separators"></div>
      <router-link v-bind:to="{ name: 'articles' }" v-if="$store.state.token != ''">ARTICLES</router-link>
      <div class="separators"></div>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link>
      <div class="separators"></div>
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
  display: flex;
  justify-content: space-between;
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Nunito Sans', sans-serif;
  font-family: 'Raleway', sans-serif;
  font-family: 'Ubuntu', sans-serif;
  font-weight: bold;
  color:black;
  background-color: grey;
  padding: 10px;
  height: 30px;
}
router-link {
  color: white;
  text-decoration: none;
  padding: 8px 15px;
}
.separators {
  margin: 0 10px;
  width: 1px;
  height: 20px;
  background-color: black;
}
.logo-name-container .company-name {
  color: rgb(234,189,99);
  font-size: 60px;
  font-weight: bold;
  display: flex;
  margin-left: -210px;
}
#nav .header-pic-container .header-pic {
  height: 60px;
  margin-left: px;
  margin-top: 07px;
}
.profile_pic {
  max-height: 75px;
}


</style>


