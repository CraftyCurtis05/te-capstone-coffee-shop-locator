# Coffee Shop Locator Web Application

Welcome to the Coffee Shop Locator Web Application! This app helps users find the closest coffee shops near their location using the **Yelp Fusion API** and provides a user-friendly interface built with **Vue.js**.

---

## Introduction

This project was developed as part of a collaborative group effort to create a web application that allows users to log in, search for coffee shops based on their location, and view essential details like the name, address, and rating of nearby coffee shops. By utilizing the Yelp Fusion API, the application fetches a list of the closest 20 coffee shops, making it easy for users to discover new spots.

---

## Features

- **User Login**: Secure user login functionality.
- **Search for Coffee Shops**: Perform address-based searches to find the closest 20 coffee shops.
- **Yelp API Integration**: Fetch data from Yelp’s API, displaying coffee shop details such as name, address, and rating.

---

## Project Structure

The application is built using **Vue.js** for the frontend. It integrates with the Yelp Fusion API for retrieving coffee shop data based on the user's location. The project also includes user authentication and a clean user interface.

/coffee-shop-locator
    /assets
        /images
        /styles
    /components
        Login.vue
        Search.vue
        ShopList.vue
    /views
        Home.vue
        SearchPage.vue
    /router
        index.js
    /store
        store.js
    App.vue
    main.js

---

## Technologies Used

- **Vue.js**: JavaScript framework used for building the user interface.
- **Yelp Fusion API**: External API used to search and retrieve coffee shop data.
- **CSS**: Styling the application for desktop.
- **JSON**: Data format used to parse the response from the Yelp API.

---

## Prerequisites

Before starting any of the Java or JavaScript projects, you’ll need the following:

- A code editor (e.g., **VS Code**)
- For JavaScript or Java projects, ensure you have **Node.js** installed, or set up a local Java environment (which includes **npm**).
- Retrive an API Key for **YELP Fusion**

---

## Collaboration
This project was developed in a group setting. Here are the key contributions:

- **Wireframes & Design**: Desktop and mobile wireframes were created to outline the user interface.
- **API Integration**: Connected the **Vue.js** frontend with the **Yelp Fusion API**, handling JSON responses to display coffee shop details.
- **Routing & State Management**: Implemented routing with **Vue Router** and used **Vuex** for state management.
- **Testing**: Performed user testing to ensure a smooth experience on desktop devices.

---

## Acknowledgements

- **Yelp Fusion API**: For providing the coffee shop data.
- **Vue.js**: For building the dynamic, reactive frontend.
