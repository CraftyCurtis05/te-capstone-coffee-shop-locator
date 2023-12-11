// Install in terminal npm i axios
// Open: https://cors-anywhere.herokuapp.com/corsdemo

import axios from 'axios';

export default{
  getCoffee(){
    var locationID = "43213";
    var queryURL = "https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/search?location=" + locationID + "&term=coffee&radius=20000&sort_by=distance&limit=20";
    var apiKey = "5r-wEn1OAX2Q8e3JQU9LJ-EJkZvBTp2MnBWe87OCHq6Flpq9XyuJRszqqkI8u3EhmmxH5ItYvD3XhPs9CG_eE_0M9wi30su2x9g_5c9QBx1KpTW81lhEFR_GdLtuZXYx"; 
    return axios.get(queryURL, {
    headers: {
        Authorization: `Bearer ${apiKey}`
      }
    })
  }
}