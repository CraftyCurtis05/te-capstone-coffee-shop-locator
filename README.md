# Coffee Shop Locator Web Application

Welcome to the Coffee Shop Locator Web Application! This app helps users find the closest coffee shops near their location using the **Yelp Fusion API** and provides a user-friendly interface built with **Vue.js**. Provides user authentication and authorization by utilizing **Spring Boot** backend and **PostgreSQL** database for data management.

---

## Introduction

This project was developed as part of a collaborative group effort to create a web application that allows users to register, log in, search for coffee shops based on their location, and view essential details like the name, address, and rating of nearby coffee shops. By utilizing the Yelp Fusion API, the application fetches a list of the closest 20 coffee shops, making it easy for users to discover new spots.

---

## Features

- **User Login**: Secure user login functionality.
- **Search for Coffee Shops**: Perform address-based searches to find the closest 20 coffee shops.
- **Yelp API Integration**: Fetch data from Yelp’s API, displaying coffee shop details such as name, address, and rating.

---

## Project Structure

The application is built using **Vue.js** for the frontend. It integrates with the Yelp Fusion API for retrieving coffee shop data based on the user's location. The project also includes user authentication and a clean user interface.

/te-capstone-coffee-shop-locator <br>
&nbsp;&nbsp;&nbsp;&nbsp;/java <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/database <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/src <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/main <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/java/com/techelevator <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/dao <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/exception <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/model <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/security <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/Application.java <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/resources <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/java/com/techelevator/dao <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/resources <br>
&nbsp;&nbsp;&nbsp;&nbsp;/vue <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/public <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/src <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/assets <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/components <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/router <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/services <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/store <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/views <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;App.vue <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;main.js <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;index.html <br>

---

## Technologies Used

- **Vue.js**: JavaScript framework used for building the user interface.
- **Yelp Fusion API**: External API used to search and retrieve coffee shop data.
- **Spring Boot: The backend framework used for verifying user details.
- **PostgreSQL: Relational database for storing user information.
- **JSON**: Data format used to parse the response from the Yelp API.

---

## Prerequisites
Before you start, make sure you have the following installed:

- A code editor (e.g., **VS Code**, **IntelliJ IDEA**)
- Ensure you have **Node.js** installed, including **npm**.
- **Java 11** or newer
- **PostgreSQL** (or any compatible relational database)
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
- **Spring Boot**: For providing an easy-to-use framework.
- **PostgreSQL**: For the powerful and reliable database management system.
