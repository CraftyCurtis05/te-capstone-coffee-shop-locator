<template>
    <div class="autocomplete-container" id="autocomplete-container"></div>
    <div class="autocomplete-container" id="autocomplete-container-country"></div>
    <div class="autocomplete-container" id="autocomplete-container-city"></div>
</template>

<script>
function addressAutocomplete(containerElement, callback, options) {
  // create input element
  var inputElement = document.createElement("input");
  inputElement.setAttribute("type", "text");
  inputElement.setAttribute("placeholder", options.placeholder);
  containerElement.appendChild(inputElement);

  // add input field clear button
  var clearButton = document.createElement("div");
  clearButton.classList.add("clear-button");
  addIcon(clearButton);
  clearButton.addEventListener("click", (e) => {
    e.stopPropagation();
    inputElement.value = '';
    callback(null);
    clearButton.classList.remove("visible");
    closeDropDownList();
  });
  containerElement.appendChild(clearButton);

  /* Current autocomplete items data (GeoJSON.Feature) */
  var currentItems;

  /* Active request promise reject function. To be able to cancel the promise when a new request comes */
  var currentPromiseReject;

  /* Focused item in the autocomplete list. This variable is used to navigate with buttons */
  var focusedItemIndex;

  /* Execute a function when someone writes in the text field: */
  inputElement.addEventListener("input", function(e) {
    var currentValue = this.value;

    /* Close any already open dropdown list */
    closeDropDownList();

    // Cancel previous request promise
    if (currentPromiseReject) {
      currentPromiseReject({
        canceled: true
      });
    }

    if (!currentValue) {
      clearButton.classList.remove("visible");
      return false;
    }

    // Show clearButton when there is a text
    clearButton.classList.add("visible");

    /* Create a new promise and send geocoding request */
    var promise = new Promise((resolve, reject) => {
      currentPromiseReject = reject;

      var apiKey = "c3cbfaf875e248d59c181184012ba8ff";
      var url = `https://api.geoapify.com/v1/geocode/autocomplete?text=${encodeURIComponent(currentValue)}&limit=5&apiKey=${apiKey}`;
      
      if (options.type) {
        url += `&type=${options.type}`;
      }

      fetch(url)
        .then(response => {
          // check if the call was successful
          if (response.ok) {
            response.json().then(data => resolve(data));
          } else {
            response.json().then(data => reject(data));
          }
        });
    });

    promise.then((data) => {
      currentItems = data.features;

      /*create a DIV element that will contain the items (values):*/
      var autocompleteItemsElement = document.createElement("div");
      autocompleteItemsElement.setAttribute("class", "autocomplete-items");
      containerElement.appendChild(autocompleteItemsElement);

      /* For each item in the results */
      data.features.forEach((feature, index) => {
        /* Create a DIV element for each element: */
        var itemElement = document.createElement("DIV");
        /* Set formatted address as item value */
        itemElement.innerHTML = feature.properties.formatted;

        /* Set the value for the autocomplete text field and notify: */
        itemElement.addEventListener("click", function(e) {
          inputElement.value = currentItems[index].properties.formatted;

          callback(currentItems[index]);

          /* Close the list of autocompleted values: */
          closeDropDownList();
        });

        autocompleteItemsElement.appendChild(itemElement);
      });
    }, (err) => {
      if (!err.canceled) {
        console.log(err);
      }
    });
  });

  /* Add support for keyboard navigation */
  inputElement.addEventListener("keydown", function(e) {
    var autocompleteItemsElement = containerElement.querySelector(".autocomplete-items");
    if (autocompleteItemsElement) {
      var itemElements = autocompleteItemsElement.getElementsByTagName("div");
      if (e.keyCode == 40) {
        e.preventDefault();
        /*If the arrow DOWN key is pressed, increase the focusedItemIndex variable:*/
        focusedItemIndex = focusedItemIndex !== itemElements.length - 1 ? focusedItemIndex + 1 : 0;
        /*and and make the current item more visible:*/
        setActive(itemElements, focusedItemIndex);
      } else if (e.keyCode == 38) {
        e.preventDefault();

        /*If the arrow UP key is pressed, decrease the focusedItemIndex variable:*/
        focusedItemIndex = focusedItemIndex !== 0 ? focusedItemIndex - 1 : focusedItemIndex = (itemElements.length - 1);
        /*and and make the current item more visible:*/
        setActive(itemElements, focusedItemIndex);
      } else if (e.keyCode == 13) {
        /* If the ENTER key is pressed and value as selected, close the list*/
        e.preventDefault();
        if (focusedItemIndex > -1) {
          closeDropDownList();
        }
      }
    } else {
      if (e.keyCode == 40) {
        /* Open dropdown list again */
        var event = document.createEvent('Event');
        event.initEvent('input', true, true);
        inputElement.dispatchEvent(event);
      }
    }
  });

  function setActive(items, index) {
    if (!items || !items.length) return false;

    for (var i = 0; i < items.length; i++) {
      items[i].classList.remove("autocomplete-active");
    }

    /* Add class "autocomplete-active" to the active element*/
    items[index].classList.add("autocomplete-active");

    // Change input value and notify
    inputElement.value = currentItems[index].properties.formatted;
    callback(currentItems[index]);
  }

  function closeDropDownList() {
    var autocompleteItemsElement = containerElement.querySelector(".autocomplete-items");
    if (autocompleteItemsElement) {
      containerElement.removeChild(autocompleteItemsElement);
    }

    focusedItemIndex = -1;
  }

  function addIcon(buttonElement) {
    var svgElement = document.createElementNS("http://www.w3.org/2000/svg", 'svg');
    svgElement.setAttribute('viewBox', "0 0 24 24");
    svgElement.setAttribute('height', "24");

    var iconElement = document.createElementNS("http://www.w3.org/2000/svg", 'path');
    iconElement.setAttribute("d", "M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z");
    iconElement.setAttribute('fill', 'currentColor');
    svgElement.appendChild(iconElement);
    buttonElement.appendChild(svgElement);
  }
  
    /* Close the autocomplete dropdown when the document is clicked. 
  	Skip, when a user clicks on the input field */
  document.addEventListener("click", function(e) {
    if (e.target !== inputElement) {
      closeDropDownList();
    } else if (!containerElement.querySelector(".autocomplete-items")) {
      // open dropdown list again
      var event = document.createEvent('Event');
      event.initEvent('input', true, true);
      inputElement.dispatchEvent(event);
    }
  });

}

addressAutocomplete(document.getElementById("autocomplete-container"), (data) => {
  console.log("Selected option: ");
  console.log(data);
}, {
	placeholder: "Enter an address here"
});

addressAutocomplete(document.getElementById("autocomplete-container-country"), (data) => {
  console.log("Selected country: ");
  console.log(data);
}, {
	placeholder: "Enter a country name here",
  type: "country"
});

addressAutocomplete(document.getElementById("autocomplete-container-city"), (data) => {
  console.log("Selected city: ");
  console.log(data);
}, {
	placeholder: "Enter a city name here"
});


</script>

<style>
    body {
    font: 16px;
    background: #f3f5f6;
    }

    .autocomplete-container {
    /*the container must be positioned relative:*/
    position: relative;
    
    margin-bottom: 20px;
    }

    .autocomplete-container input {
    width: calc(100% - 43px);
    outline: none;
    
    border: 1px solid rgba(0, 0, 0, 0.2);
    padding: 10px;
    padding-right: 31px;
    font-size: 16px;
    }

    .autocomplete-items {
    position: absolute;
    border: 1px solid rgba(0, 0, 0, 0.1);
    box-shadow: 0px 2px 10px 2px rgba(0, 0, 0, 0.1);
    border-top: none;
    z-index: 99;
    /*position the autocomplete items to be the same width as the container:*/
    top: calc(100% + 2px);
    left: 0;
    right: 0;
    
    background-color: #fff;
    }

    .autocomplete-items div {
    padding: 10px;
    cursor: pointer;
    }

    .autocomplete-items div:hover {
    /*when hovering an item:*/
    background-color: rgba(0, 0, 0, 0.1);
    }

    .autocomplete-items .autocomplete-active {
    /*when navigating through the items using the arrow keys:*/
    background-color: rgba(0, 0, 0, 0.1);
    }

    .clear-button {
    color: rgba(0, 0, 0, 0.4);
    cursor: pointer;
    
    position: absolute;
    right: 5px;
    top: 0;

    height: 100%;
    display: none;
    align-items: center;
    }

    .clear-button.visible {
    display: flex;
    }


    .clear-button:hover {
    color: rgba(0, 0, 0, 0.6);
    }
</style>



















<!-- <template><div class="autocomplete-container" id="autocomplete-container"></div>
<div class="autocomplete-container" id="autocomplete-container-country"></div>
<div class="autocomplete-container" id="autocomplete-container-city"></div>
    <div id="links" class="text-center">
        <h1>Locator</h1>  
        <div>
            <form class="new-locator-form">
                <input class="locator-form" name="street-input" type="text" placeholder="Street Address"/>
                <input class="locator-form" name="city-input" type="text" placeholder="City"/>
                <input class="locator-form" name="state-input" type="text" placeholder="State"/>
                <input class="locator-form" name="zipCode-input" type="text" placeholder="Zip Code"/>
                <button>Search</button>
            </form>
        </div>
        <div>
            <img src="src\assets\googleMaps.jpg">
        </div>
    </div>
  </template> -->