<template>
  <h1>Profile</h1>  
  <p>Jolt Up Your Profile</p>
    <div class="favorites-link"><a href="/favorites"></a></div>
    <div id="change-profile-pic">
        <h3>Change Profile Picture</h3>
        <ProfilePictureUpload />
    </div>
</template>

<script>
import ProfilePictureUpload from '../components/ProfilePictureUpload.vue';

export default {
  components: {
    ProfilePictureUpload
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
#change-profile-pic {
  display: flex;
  position: relative;
  left: 100px;
}
h3 {
  display: flex;
  position: relative;
  left: 425px;
  bottom: -30px;
  font-family: 'Lobster Two', sans-serif;
  font-family: 'Ubuntu', sans-serif;
}
a {
  text-decoration: none;
  font-size: 20px;
  display: flex;
  position: relative;
  left: 500px;
}
</style>