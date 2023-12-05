<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'links' }" v-if="$store.state.token != ''">Links</router-link>
      <router-link v-bind:to="{ name: 'articles' }" v-if="$store.state.token != ''">Articles</router-link>

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
