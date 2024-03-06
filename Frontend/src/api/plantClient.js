import BaseClass from "../util/baseClass";
import axios from 'axios'

/**
 * Client to call the PlantParent.
 *
 */
export default class plantClient extends BaseClass {

    constructor(props = {}){
        super();
        const methodsToBind = ['clientLoaded', 'getPlant', 'createPlant',
                               'getPlantCollection', 'getPlantByName', 'deletePlant'];
        this.bindClassMethods(methodsToBind, this);
        this.props = props;
        this.clientLoaded(axios);
    }

    /**
     * Run any functions that are supposed to be called once the client has loaded successfully.
     * @param client The client that has been successfully loaded.
     */
    clientLoaded(client) {
        this.client = client;
        if (this.props.hasOwnProperty("onReady")){
            this.props.onReady();
        }
    }

    /**
    * Gets a list of plants by name
    * @param plantName Name of the plant to search for
    * @param errorCallback (Optional) A function to execute if the call fails.
    * @returns The list of plants
    */
    async getPlant(plantName, errorCallback) {
        try {
            const response = await this.client.get(`/plant/${plantName}`);
            return response.data;
        } catch (error) {
            this.handleError("getPlant", error, errorCallback)
        }
    }

    /**
     * Creates a new plant in the collection.
     * @param name Name of the plant
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The created plant
     */
    async createPlant(name, errorCallback) {
        try {
            const response = await this.client.post(`/plant/collection/`, {
                name: name
            });
            return response.data;
        } catch (error) {
            this.handleError("createPlant", error, errorCallback);
        }
    }

/**
     * Gets the entire plant collection.
     * @param errorCallback (Optional) A function to execute if the call fails.
     * @returns The list of plants in the collection.
     */
    async getPlantCollection(errorCallback) {
        try {
            const response = await this.client.get(`/plant/collection/all`);
            return response.data;
        } catch (error) {
            this.handleError("getPlantCollection", error, errorCallback);
        }
    }


    /**
         * Gets a plant by name from the collection.
         * @param plantName Name of the plant to search for
         * @param errorCallback (Optional) A function to execute if the call fails.
         * @returns The plant
         */
        async getPlantByName(plantName, errorCallback) {
            try {
                const response = await this.client.get(`/plant/collection/${plantName}`);
                return response.data;
            } catch (error) {
                this.handleError("getPlantByName", error, errorCallback);
            }
        }


        /**
         * Deletes a plant from the collection.
         * @param id ID of the plant to delete
         * @param errorCallback (Optional) A function to execute if the call fails.
         */
        async deletePlant(id, errorCallback) {
            try {
                await this.client.delete(`/plant/collection/${id}`);
            } catch (error) {
                this.handleError("deletePlant", error, errorCallback);
            }
        }


    /**
     * Helper method to log the error and run any error functions.
     * @param error The error received from the server.
     * @param errorCallback (Optional) A function to execute if the call fails.
     */
    handleError(method, error, errorCallback) {
        console.error(method + " failed - " + error);
        if (error.response.data.message !== undefined) {
            console.error(error.response.data.message);
        }
        if (errorCallback) {
            errorCallback(method + " failed - " + error);
        }
    }
}
