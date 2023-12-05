<template>
  <div id="capstone-app">
    <div id="nav">
      <div><img class="header_pic" src="src\assets\coffeeLocator.jpg"></div>
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'links' }" v-if="$store.state.token != ''">Links</router-link>
      <router-link v-bind:to="{ name: 'articles' }" v-if="$store.state.token != ''">Articles</router-link>
      <router-link v-bind:to="{ name: 'locator' }" v-if="$store.state.token != ''">Locator</router-link>
      <router-link v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''"><img class="header_pic" src="src\assets\profile.jpg"></router-link>


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
#nav {
  align-items: center;
  padding: 20px;
  display: flex;
  justify-content: space-between;
}
.header_pic {
  max-height: 100px;
}

</style>


