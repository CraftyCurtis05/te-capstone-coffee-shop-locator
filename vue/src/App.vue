<template>
  <div id="capstone-app">
    <div id="nav" v-if="!$route.meta.hideNavBar">
      <div class="header-logo-container">
        <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''"><img class="header-logo" src="src\assets\Jolt Logo.png"></router-link>
      </div>
      <!-- <div class="logo-name-container">
        <div class="company-name">JOlt</div>
      </div> -->
      <div class="links-container">
        <router-link class="home-link" v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">HOME</router-link>
        <div class="separators" id="sep1"></div>
        <router-link class="locator-link" v-bind:to="{ name: 'locator' }" v-if="$store.state.token != ''">LOCATOR</router-link>
        <div class="separators" id="sep2"></div>
        <router-link class="shop-link" v-bind:to="{ name: 'links' }" v-if="$store.state.token != ''">SHOP</router-link>
        <div class="separators" id="sep3"></div>
        <router-link class="articles-link" v-bind:to="{ name: 'articles' }" v-if="$store.state.token != ''">ARTICLES</router-link>
        <div class="separators" id="sep4"></div>
        <router-link class="logout-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">LOGOUT</router-link>
      </div>
        <!-- <div class="separators"></div> -->
        <router-link v-bind:to="{ name: 'profile' }" v-if="$store.state.token != ''"><img class="profile_pic" src="src\assets\profile (2).png"></router-link>
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

.links-container {
  align-items: center;
  display: flex;
  justify-content: space-between;
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Nunito Sans', sans-serif;
  font-family: 'Raleway', sans-serif;
  font-family: 'Ubuntu', sans-serif;
  font-weight: bold;
  color:black;
  background-color: rgb(160, 153, 145);
  padding: 10px;
  height: 15px;
}
.links-container .home-link {
  justify-content: center;
  position: relative;
  left: 300px;
  font-size: 14px;
  color: rgb(245, 242, 242);
  text-decoration: none;
}

#sep1 {
  justify-content: center;
  margin: 0 10px;
  width: 1px;
  height: 20px;
  position: relative;
  left: 228px;
}
.locator-link {
  justify-content: center;
  position: relative;
  left: 150px;
  font-size: 14px;
  color: rgb(245, 242, 242);
  text-decoration: none;
}
#sep2 {
  justify-content: center;
  margin: 0 10px;
  width: 1px;
  height: 20px;
  position: relative;
  left: 75px;
}
.shop-link {
  justify-content: center;
  position: relative;
  left: 0px;
  font-size: 14px;
  color: rgb(245, 242, 242);
  text-decoration: none;
}
#sep3 {
  justify-content: center;
  margin: 0 10px;
  width: 1px;
  height: 20px;
  position: relative;
  left: -75px;
}
.articles-link {
  justify-content: center;
  position: relative;
  left: -150px;
  font-size: 14px;
  color: rgb(245, 242, 242);
  text-decoration: none;
}
#sep4 {
  justify-content: center;
  margin: 0 10px;
  width: 1px;
  height: 20px;
  position: relative;
  left: -225px;
}
.logout-link {
  justify-content: center;
  position: relative;
  left: -300px;
  font-size: 14px;
  color: rgb(245, 242, 242);
  text-decoration: none;
}
.separators {
  margin: 0 10px;
  width: 1px;
  height: 20px;
  background-color: black;
}
#nav .header-logo-container .header-logo {
  max-width: 290px;
  position: absolute;
  top: -56.5px;
  left: -90px;
}
.profile_pic {
  height: 40px;
  position: absolute;
  right: 20px;
  top: 6px;
}
</style>
