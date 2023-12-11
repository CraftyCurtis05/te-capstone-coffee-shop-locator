import axios from 'axios';

var queryURL = "https://cors-anywhere.herokuapp.com/https://api.yelp.com/v3/businesses/search";
var apiKey = "5r-wEn1OAX2Q8e3JQU9LJ-EJkZvBTp2MnBWe87OCHq6Flpq9XyuJRszqqkI8u3EhmmxH5ItYvD3XhPs9CG_eE_0M9wi30su2x9g_5c9QBx1KpTW81lhEFR_GdLtuZXYx"; 

const options = {
  url: queryURL,
  method: "GET",
  params: {
    "term": 'coffee',
    "radius": '20000',
    "sort_by": 'distance',
    "limit": '20'
  },
  headers: {
    "accept": 'application/json',
    "Authorization": `Bearer ${apiKey}`,
    "x-requested-with": "xmlhttprequest",
    "Access-Control-Allow-Origin":"*",
    "changeOrigin": 'true'
  }
};

export default{
  getCoffee(){
    axios
      .request(options)
      .then(function (response) {
        console.log(response.data);
      })
      .catch(function (error) {
        console.error(error);
      });
    }
  }