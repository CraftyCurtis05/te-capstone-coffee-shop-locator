<!-- <template>
    <div class='carousel-view'>
      <transition-group
        class='carousel'
        tag="div">
        <div
          v-for="slide in slides" 
          class='slide'
          :key="slide.id">
          <h4> {{ slide.image }} </h4>
        </div>
      </transition-group>
      <div class='carousel-controls'>
        <button class='carousel-controls__button' @click="previous">prev</button>
        <button class='carousel-controls__button' @click="next">next</button>
      </div>
    </div>
  </template>

<script>
export default {
  data () {
    return {
      slides: [
        {
            image: 'I am Slide A',
          id: 1
        },
        {
            image: 'I am Slide B',
          id: 2
        },
        {
            image: 'I am Slide C',
          id: 3
        },
        {
            image: 'I am Slide D',
          id: 4
        },
        {
            image: 'I am Slide E',
          id: 5
        }
      ]
    }
  },
  methods: {
    next () {
      const first = this.slides.shift()
      this.slides = this.slides.concat(first)
    },
    previous () {
      const last = this.slides.pop()
      this.slides = [last].concat(this.slides)
    }
  }
}
</script>

<style>
.carousel-view {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.carousel {
  display: flex;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  
  width: 24em;
  min-height: 25em;
}
.slide {
  flex: 0 0 20em;
  height: 20em;
  margin: 1em;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: transform 0.3s ease-in-out;
}
.slide:first-of-type {
  opacity: 0;
}
.slide:last-of-type {
  opacity: 0;
}
</style> -->

<template>
    <div class="carousel-container">
      <div class="carousel">
        <transition :name="transitionName">
          <div :key="currentIndex" class="carousel-item">
            <a :href="imageLinks[currentIndex]" target="_blank">
            <img :src="images[currentIndex]" alt="Slide" />
            </a>
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
        'http://www.google.com/',
        'https://www.yahoo.com/?guccounter=1',
        'https://www.bing.com/',
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

