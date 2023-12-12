<template>
    <div class="favorites-container">
        <p>Your favorite coffee shops</p>
         <div class="favorites-button" >
            <button v-on:click.prevent="setFavorite(true)">Favorite Coffee Shop</button>
        </div>
    </div>
</template>

<script>
export default {
    data () {
        return { 
            enableFavorite: {
                type: Boolean,
                default:false
            }
        };
    },
    methods: {
        setFavorite(value) {
            this.$store.commit('SET_FAVORITE_STATUS',  );
        }
    }
};
</script>