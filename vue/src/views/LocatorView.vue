<template><div class="autocomplete-container" id="autocomplete-container"></div>
<div class="autocomplete-container" id="autocomplete-container-country"></div>
<div class="autocomplete-container" id="autocomplete-container-city"></div>
<div id="links" class="text-center">
  <h1>Locator</h1>  
    <form class="new-locator-form">
      <input class="locator-form" name="street-input" type="text" placeholder="Street Address"/>
      <input class="locator-form" name="city-input" type="text" placeholder="City"/>
      <input class="locator-form" name="state-input" type="text" placeholder="State"/>
      <input class="locator-form" name="zipCode-input" type="text" placeholder="Zip Code"/>
      <button>Search</button>
    </form>
    <div>
      <img src="src\assets\googleMaps.jpg">
    </div>
  </div>
</template>

<style scoped>
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