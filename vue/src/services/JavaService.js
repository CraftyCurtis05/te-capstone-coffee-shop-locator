import axios from 'axios';

export default {

    makeFavorite(favorites) {
        return axios.post('/favorites/', favorites)
    }
}