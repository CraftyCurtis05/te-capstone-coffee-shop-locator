<template>
    <footer class="footer">
      <div class="container">
        <span>&copy; {{ year }} {{ companyName }}</span>
        <p class="slogan">Be Brew-tiful. Sip, Savor, Repeat.</p> <!-- Add your slogan here -->
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    data() {
      return {
        year: new Date().getFullYear(),
        companyName: "Jolt Coffee Shop Locator",
      };
    },
  };
  </script>
  
  <style scoped>
  .footer {
    background-color: transparent;
    padding: 20px 0;
    text-align: center;
  }
  
  .container {
    max-width: 1200px;
    margin: 0 auto;
  }
  
  .footer span {
    color: grey;
    font-size: 14px;
    line-height: 1.5;
  }
  
  .slogan {
    font-size: 15px; 
    margin-top: 10px; 
    font-weight: bold; 
    color: rgb(234,189,99);
  }
  </style>
  