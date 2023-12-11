<template><div class="autocomplete-container" id="autocomplete-container"></div>
<div class="autocomplete-container" id="autocomplete-container-country"></div>
<div class="autocomplete-container" id="autocomplete-container-city"></div>
<div id="links" class="text-center">
  <h1>Locator</h1>
  <!-- WE NEED A PARAGRAPH DESCRIBING WHAT THIS PAGE IS -->
  <p>.........</p>  
    <form class="locator-form" >
      <input name="street-input" type="text" placeholder="Street Address"/>
      <input name="city-input" type="text" placeholder="City"/>
      <input name="state-input" type="text" placeholder="State"/>
      <input name="zipCode-input" type="text" placeholder="Zip Code"/>
      <button>Search</button>
    </form>
    <div class="locator-map-pic">
      <img src="\src\assets\googleMap.png">
    </div>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Lobster+Two&family=Ubuntu&display=swap');

body {
    text-align: center;
}
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
.locator-form {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 20px;
}
img {
  resize: both;
  width: 1250px;
}
</style>