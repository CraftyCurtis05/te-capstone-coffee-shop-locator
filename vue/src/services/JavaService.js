import axios from 'axios';

export default {

    makeFavorite(favorites) {
        return axios.post('/favorites/', favorites)
    },
    getFavorite(favorites) {
        return axios.get('/favorites', favorites)
    }
}