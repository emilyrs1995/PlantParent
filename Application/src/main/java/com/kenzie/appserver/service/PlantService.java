package com.kenzie.appserver.service;

import com.kenzie.appserver.model.CreatePlantRequest;
import com.kenzie.appserver.model.CreatePlantResponse;
import com.kenzie.appserver.repositories.PlantRepository;
import com.kenzie.capstone.service.model.GetPlantListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantService {

//    private final PlantRepository plantRepository;
//
//    @Autowired
//    public PlantService(PlantRepository plantRepository) {
//        this.plantRepository = plantRepository;
//    }
//
//    public List<GetPlantListResponse> getPlants() {
//        // Implement logic to retrieve a list of plants from the repository
//        return plantRepository.getAllPlants();
//    }
//
//    public GetPlantListResponse getPlantById(long plantId) {
//        // Implement logic to retrieve a specific plant by ID from the repository
//        return plantRepository.getPlantById(plantId);
//    }
//
//    public CreatePlantResponse createPlant(CreatePlantRequest createPlantRequest) {
//        // Implement logic to create a new plant and return the created plant
//        return plantRepository.createPlant(createPlantRequest);
//    }
//
//    public GetPlantListResponse updatePlant(long plantId, CreatePlantRequest updatePlantRequest) {
//        // Implement logic to update an existing plant and return the updated plant
//        return plantRepository.updatePlant(plantId, updatePlantRequest);
//    }
//
//    public void deletePlant(long plantId) {
//        // Implement logic to delete a plant by ID
//        plantRepository.deletePlant(plantId);
//    }
}
