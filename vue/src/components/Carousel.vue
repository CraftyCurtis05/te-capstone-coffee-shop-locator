<template>
    <div class="carousel-container">
      <div class="carousel">
        <transition :name="transitionName">
          <div :key="currentIndex" class="carousel-item">
            <router-link :to="imageLinks[currentIndex]">
            <img :src="images[currentIndex]" alt="Slide" />
            </router-link>
          </div>
        </transition>
      </div>
      <button @click="prevSlide" class="prev-btn">Previous</button>
      <button @click="nextSlide" class="next-btn">Next</button>
    </div>
  </template>
  <script>
  export default {
    data() {
      return {
        images: [
          'https://images.pexels.com/photos/3184286/pexels-photo-3184286.jpeg?auto=compress&cs=tinysrgb&w=800',
          'https://images.pexels.com/photos/2159065/pexels-photo-2159065.jpeg?auto=compress&cs=tinysrgb&w=600',
          'https://images.pexels.com/photos/1516983/pexels-photo-1516983.jpeg?auto=compress&cs=tinysrgb&w=600',
          'https://images.pexels.com/photos/846080/pexels-photo-846080.jpeg?auto=compress&cs=tinysrgb&w=600'
          // Add more image URLs as needed
        ],
        imageLinks: [
        'locator',
        'links',
        'articles',
        'profile'
      ],
        currentIndex: 0,
        transitionName: 'slide',
      };
    },
    methods: {
      prevSlide() {
        this.transitionName = 'slide-prev';
        this.currentIndex = (this.currentIndex - 1 + this.images.length) % this.images.length;
      },
      nextSlide() {
        this.transitionName = 'slide-next';
        this.currentIndex = (this.currentIndex + 1) % this.images.length;
      },
    },
  };
  </script>

  <style scoped>
  .carousel-container {
    max-width: 600px;
    margin: auto;
    position: relative;
  }
  .carousel {
    overflow: hidden;
  }
  .carousel-item {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 200px; /* Adjust the height as needed */
  }
  .prev-btn,
  .next-btn {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    font-size: 18px;
    cursor: pointer;
    padding: 10px;
  }
  .prev-btn {
    left: 10px;
  }
  .next-btn {
    right: 10px;
  }
  .slide-prev-enter-active,
  .slide-next-enter-active,
  .slide-prev-leave-active,
  .slide-next-leave-active {
    transition: transform 0.5s;
  }
  .slide-prev-enter, .slide-next-leave-to {
    transform: translateX(-100%);
  }
  .slide-next-enter, .slide-prev-leave-to {
    transform: translateX(100%);
  }
  </style>

