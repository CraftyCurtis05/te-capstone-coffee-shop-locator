import axios from 'axios';

const options = {
  method: 'GET',
  url: 'https://api.yelp.com/v3/businesses/search',
  params: {
    location: '45011',
    term: 'coffee',
    radius: '8000',
    categories: '',
    sort_by: 'best_match',
    limit: '20'
  },
  headers: {
    accept: 'application/json',
    Authorization: 'Bearer 5r-wEn1OAX2Q8e3JQU9LJ-EJkZvBTp2MnBWe87OCHq6Flpq9XyuJRszqqkI8u3EhmmxH5ItYvD3XhPs9CG_eE_0M9wi30su2x9g_5c9QBx1KpTW81lhEFR_GdLtuZXYx',
    changeOrigin: 'true'
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