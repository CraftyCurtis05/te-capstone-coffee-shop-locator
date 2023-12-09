<template>
  <div id="login-container">
    <div class="logo-company-container">
      <div class="logo-container">
        <img src="src\assets\Jolt Logo.png" alt="Logo"/>
      </div>
    </div>
    <!-- <div class="logo-name-container">
      <div class="company-name">JOlt</div>
    </div> -->
    <div class="form-container">
      <div class="login-form">
        <form v-on:submit.prevent="login">
          <h1 class="sign-in-text">Please Sign In</h1>
          <div role="alert" v-if="invalidCredentials">
            Invalid username and password!
          </div>
          <div role="alert" v-if="this.$route.query.registration">
            Thank you for registering, please sign in.
          </div>
          <div class="form-input-group">
            <label for="username">Username</label>
            <input type="text" id="username" v-model="user.username" required autofocus />
          </div>
          <div class="form-input-group">
            <label for="password">Password</label>
            <input type="password" id="password" v-model="user.password" required />
          </div>
          <button type="submit">Sign in</button>
          <div class="button-container">
            <router-link v-bind:to="{ name: 'register' }">
              <button class="register-button">Register</button>
            </router-link>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import authService from "../services/AuthService";
export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');
/* .company-name {
    font-family: 'Lobster Two', sans-serif;
    font-family: 'Ubuntu', sans-serif;
} */
.form-container .login-form .button-container .register-button {
  display: flex;
  margin-top: -21px;
  margin-left: 140px;
}
.form-container .login-form button {
  margin-left: 70px;
}
#login-container .form-container {
  margin-top: -50px;
}
.form-container .login-form .sign-in-text {
  margin-left: 30px;
}
#login-container{
  width:100vw;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: url('src\\assets\\beans-coffee.gif') no-repeat center center fixed;
  background-size: cover;
}
/* .logo-name-container {
  margin-left: 250px;
} */
.form-input-group #username {
  margin-left: -04px;
}
.logo-company-container {
  text-align: center;
  margin-bottom: 20px;
  display: flex;
  align-items: center;
}
.logo-container {
  text-align: center;
  margin-right: 51px;
  margin-bottom: -580px;
}
/* .company-name {
  margin-top: 150px;
  display: flex;
  margin-right: 160px;
  font-size: 200px;
  font-weight: bold;
  color: rgb(234,189,99);
} */
.login-form {
  display: flex;
  align-items: center;
  position:absolute;
  top: 400px;
  right: 780px;
  max-width: 300px;
  padding: 20px;
  border-radius: 8px;
}
.form-input-group {
  margin-bottom: 1rem;
  color: white;
}
label {
  margin-right: 0.5rem;
}
h1 {
  color: white;
}
img {
  position: absolute;
  top: -20px;
  right: 275px
}
.register-button {
  margin-left: 170px;
}
</style>