// Install in terminal npm install
// Install in terminal npm i axios
// Open: https://cors-anywhere.herokuapp.com/corsdemo
// npm run dev

import axios from 'axios';

export default{
  getCoffee(locationID){
    let queryURL = "https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/search?location="+locationID+"&term=coffee&radius=20000&sort_by=distance&limit=20";
    const apiKey = "NJ4eGlHYsgwW4Gpl8BkAzRphGMh-RUz7Epip4-eIc0wKrHIQfOzBRxJtoOFWgMKuHNYCaW57_Z9y7BCY_XAtTekR8VdvAy3ZGxyArftOW4KBaRS9c2x2f8HFHM95ZXYx"; 
    
    return axios.get(queryURL, {
    
      headers: {
        Authorization: `Bearer ${apiKey}`
      }
    })
  }
}