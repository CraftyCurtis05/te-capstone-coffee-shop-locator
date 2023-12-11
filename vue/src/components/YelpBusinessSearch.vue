<template>
    <div>
        <h1>Hello World</h1>
    </div>
</template>

<script>
    import YelpService from '../services/YelpService';

    export default {
        data() {
            return { 
                results: []
            }
        },
        methods: {
            getResults() {
                YelpService.getCoffee()
                .then(response => {
                    this.results = response.data;
                })
                .catch(error => {
                    console.log(error);
                })
            }
        },
        created() {
            this.getResults();
        }
    }
</script>