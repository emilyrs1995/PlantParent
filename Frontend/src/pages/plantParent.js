//import BaseClass from "../util/baseClass";
//import DataStore from "../util/DataStore";
//import plantClient from "../api/plantClient";
//
///**
// * Logic needed for the PlantParent application.
// */
//class PlantParentPage extends BaseClass {
//
//    constructor() {
//        super();
//        this.bindClassMethods(['onPlantSearch', 'onCreatePlant', 'renderPlants', 'onGetPlant'], this);
//        this.dataStore = new DataStore();
//    }
//
//
//    /**
//     * Once the page has loaded, set up the event handlers and fetch any initial plant data.
//     */
//    async mount() {
//        document.getElementById('plant-search-form').addEventListener('submit', this.onPlantSearch);
//        document.getElementById('create-plant-form').addEventListener('submit', this.onCreatePlant);
//        document.getElementById('show-my-plants').addEventListener('click', this.onGetPlant);
//        //add delete event listener
//
//        document.getElementById('close-mourning-popup').addEventListener('click', () => {
//            document.getElementById('plant-mourning-popup').classList.add('hidden');
//
//        this.client = new plantClient();
//        this.dataStore.addChangeListener(this.renderPlants);
//    }
//
//  // Render Methods --------------------------------------------------------------------------------------
//
//    async renderPlants() {
//        const plantListElement = document.getElementById("plant-list");
//        plantListElement.innerHTML = "";
//
//        const plants = this.dataStore.get("plants");
//
//        if (plants) {
//            plants.forEach((plant) => {
//                const plantItem = document.createElement("div");
//                plantItem.classList.add("plant-item");
//
//                const plantNameElement = document.createElement("p");
//                plantNameElement.innerText = plant.plantName;
//
//                const plantImageElement = document.createElement("img");
//                plantImageElement.src = plant.imgUrl;
//
//            // Delete button creation
//                const deleteButton = document.createElement('button');
//                deleteButton.textContent = 'Delete';
//                deleteButton.classList.add('delete-button');
//                deleteButton.dataset.plantId = plant.plantId;
//
//
//                plantItem.appendChild(plantNameElement);
//                plantItem.appendChild(plantImageElement);
//                plantListElement.appendChild(plantItem);
//            });
//        } else {
//            plantListElement.innerHTML = "No plants in your collection yet!";
//        }
//    }
//
//  // Event Handlers ----------------------------------------------------------------------------------
//
//    async onPlantSearch(event) {
//        event.preventDefault();
//
//        const plantName = document.getElementById("plant-search-field").value;
//        this.dataStore.set("plants", null);
//
//        try {
//            const foundPlants = await this.client.getPlant(plantName);
//            this.dataStore.set("plants", foundPlants);
//            this.renderPlants(); //update search results display
//            this.showMessage(`Found some plants matching '${plantName}'!`);
//        } catch (error) {
//            this.errorHandler("Error searching for plants. Please try again.");
//        }
//    }
//
//
//    async function fetchPlantData(plantName ) {
//        const response = await fetch(`/searchPlant?name=${encodeURIComponent(plantName)}`);
//
//        try {
//            const response = await fetch(apiEndpoint);
//
//            if (!response.ok) {
//                throw new Error(`API request failed with status ${response.status}`);
//            }
//
//            const plantData = await response.json();
//            displaySearchResults(plantData);
//        } catch (error) {
//            console.error("Error fetching plant data:", error);
//        }
//    }
//
//    function displaySearchResults(plantData) {
//        searchResultsContainer.innerHTML = ''; // clear the previous search results
//
//        if (plantData.length === 0) {
//            const noResultsMessage = document.createElement('p');
//            noResultsMessage.textContent = "No plants found. Try a different search.";
//            searchResultsContainer.appendChild(noResultsMessage);
//            return;
//        }
//
//        plantData.forEach(plant => {
//            const plantResult = document.createElement('div');
//            plantResult.classList.add('plant-result');
//
//            plantResult.innerHTML = `
//                <h3>${plant.plantName}</h3>
//                <p>Scientific Name: ${plant.scientificName.join(', ')}</p>
//                <img src="${plant.imgUrl}" alt="${plant.plantName}"/>
//                <p>Cycle: ${plant.cycle}</p>
//                <p>Watering: ${plant.watering}</p>
//                <p>Sunlight: ${plant.sunlight}</p>
//                <button class="delete-button" data-plant-id="${plant.id}">Delete</button>
//
//            `;
//            searchResultsContainer.appendChild(plantResult);
//        });
//    }
//
///*...........*/
//    async onCreatePlant(event) {
//        event.preventDefault();
//            this.dataStore.set("plants", null); // Clear previous results if any
//
//            const plantName = document.getElementById("create-plant-name-field").value;
//
//            try {
//                const createdPlant = await this.client.createPlant(plantName);
//                this.dataStore.set("plants", [createdPlant]);  // Update with the new plant
//                this.showMessage(`Plant '${createdPlant.plantName}' added to your collection!`);
//            } catch (error) {
//                this.errorHandler("Error creating plant. Please try again.");
//            }
//        }
//
//
//    async onGetPlant(event) {
//        event.preventDefault();
//
//        try {
//            const myPlants = await this.client.getPlantCollection();
//            this.dataStore.set("plants", myPlants);
//            this.showMessage("Retrieved your plant collection!");
//        } catch (error) {
//            this.errorHandler("Error getting your plant collection. Please try again.");
//        }
//    }
//
//    async onDeletePlant(event) {
//            event.preventDefault();
//
//            const plantId = event.target.dataset.plantId;
//
//            try {
//                await this.client.deletePlant(plantId);
//
//                // Update plant list (optimistic update for better UX)
//                const currentPlants = this.dataStore.get("plants");
//                const updatedPlants = currentPlants.filter(plant => plant.plantId !== plantId);
//                this.dataStore.set("plants", updatedPlants);
//
//                this.showMessage(`RIP`); // show RIP image to mourn plant here? moment of silence?
//                // Show the pop-up
//                document.getElementById('plant-mourning-popup').classList.remove('hidden');
//            } catch (error) {
//                this.errorHandler("Error deleting plant. Please try again.");
//            }
//        }
//
//    async onGetPlantCollection(event) {
//            event.preventDefault();
//
//            try {
//                const allPlants = await this.client.getPlantCollection();
//                this.dataStore.set("plants", allPlants);
//                this.showMessage("Retrieved your plant collection!");
//            } catch (error) {
//                this.errorHandler("Error getting your plant collection. Please try again.");
//            }
//        }
//
//    // Helper method (from examplePage.js)
//        showMessage(message) {
//            console.log(message);
//        }
//
//    /**
//    * Main method to run when the page contents have loaded.
//    */
//    const main = async () => {
//        const plantParentPage = new PlantParentPage();
//        await plantParentPage.mount();
//        console.log(plantParentPage); //debug line
//    };
//
//    window.addEventListener('DOMContentLoaded', main);
