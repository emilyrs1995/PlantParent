import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import plantClient from "../api/plantClient";

/**
 * Logic needed for the PlantParent application.
 */
class PlantParentPage extends BaseClass {

    constructor() {
        super();
        this.bindClassMethods(['onPlantSearch', 'onCreatePlant', 'renderPlants', 'onGetPlant'], this);
        this.dataStore = new DataStore();
    }


    /**
     * Once the page has loaded, set up the event handlers and fetch any initial plant data.
     */
    async mount() {
        document.getElementById('plant-search-form').addEventListener('submit', this.onPlantSearch);
        document.getElementById('create-plant-form').addEventListener('submit', this.onCreatePlant);
        document.getElementById('show-my-plants').addEventListener('click', this.onGetPlant);

        this.client = new plantClient();
        this.dataStore.addChangeListener(this.renderPlants);
    }

  // Render Methods --------------------------------------------------------------------------------------

    async renderPlants() {
        const plantListElement = document.getElementById("plant-list");
        plantListElement.innerHTML = "";

        const plants = this.dataStore.get("plants");

        if (plants) {
            plants.forEach((plant) => {
                const plantItem = document.createElement("div");
                plantItem.classList.add("plant-item");

                const plantNameElement = document.createElement("p");
                plantNameElement.innerText = plant.plantName;

                const plantImageElement = document.createElement("img");
                plantImageElement.src = plant.imgUrl;

                plantItem.appendChild(plantNameElement);
                plantItem.appendChild(plantImageElement);
                plantListElement.appendChild(plantItem);
            });
        } else {
            plantListElement.innerHTML = "No plants in your collection yet!";
        }
    }

  // Event Handlers ----------------------------------------------------------------------------------

    async onPlantSearch(event) {
        event.preventDefault();

        const plantName = document.getElementById("plant-search-field").value;
        this.dataStore.set("plants", null);

        try {
            const foundPlants = await this.client.getPlant(plantName);
            this.dataStore.set("plants", foundPlants);
            this.showMessage(`Found some plants matching '${plantName}'!`);
        } catch (error) {
            this.errorHandler("Error searching for plants. Please try again.");
        }
    }

    async onCreatePlant(event) {
        event.preventDefault();
            this.dataStore.set("plants", null); // Clear previous results if any

            const plantName = document.getElementById("create-plant-name-field").value;

            try {
                const createdPlant = await this.client.createPlant(plantName);
                this.dataStore.set("plants", [createdPlant]);  // Update with the new plant
                this.showMessage(`Plant '${createdPlant.plantName}' added to your collection!`);
            } catch (error) {
                this.errorHandler("Error creating plant. Please try again.");
            }
        }


    async onGetPlant(event) {
        event.preventDefault();  // depending if it's a button or link

        try {
            const myPlants = await this.client.getPlantCollection();
            this.dataStore.set("plants", myPlants);
            this.showMessage("Retrieved your plant collection!");
        } catch (error) {
            this.errorHandler("Error getting your plant collection. Please try again.");
        }
    }

    async onDeletePlant(event) {
            event.preventDefault();

            const plantId = event.target.dataset.plantId; // add this in the HTML

            try {
                await this.client.deletePlant(plantId);

                // Update plant list (optimistic update for better UX)
                const currentPlants = this.dataStore.get("plants");
                const updatedPlants = currentPlants.filter(plant => plant.plantId !== plantId);
                this.dataStore.set("plants", updatedPlants);

                this.showMessage(`RIP`); // show RIP image to mourn plant here? moment of silence?
            } catch (error) {
                this.errorHandler("Error deleting plant. Please try again.");
            }
        }

    async onGetPlantCollection(event) {
            event.preventDefault();

            try {
                const allPlants = await this.client.getPlantCollection();
                this.dataStore.set("plants", allPlants);
                this.showMessage("Retrieved your plant collection!");
            } catch (error) {
                this.errorHandler("Error getting your plant collection. Please try again.");
            }
        }

    // Helper method (from examplePage.js)
        showMessage(message) {
            console.log(message);
        }

    /**
    * Main method to run when the page contents have loaded.
    */
    const main = async () => {
        const examplePage = new ExamplePage();
        examplePage.mount();
    };

    window.addEventListener('DOMContentLoaded', main);
