package com.kenzie.appserver.controller;

import com.kenzie.appserver.model.CreatePlantRequest;
import com.kenzie.appserver.model.CreatePlantResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plants")
public class PlantController {

//    private final PlantService plantService;
//
//    @Autowired
//    public PlantController(PlantService plantService) {
//        this.plantService = plantService;
//    }
//
//    @GetMapping
//    public List<GetPlantListResponse> getPlants() {
//        return plantService.getPlants();
//    }
//
//    @GetMapping("/{plantId}")
//    public GetPlantListResponse getPlantById(@PathVariable long plantId) {
//        return plantService.getPlantById(plantId);
//    }
//
//    @PostMapping
//    public CreatePlantResponse createPlant(@RequestBody CreatePlantRequest createPlantRequest) {
//        return plantService.createPlant(createPlantRequest);
//    }
//
//    @PutMapping("/{plantId}")
//    public GetPlantListResponse updatePlant(@PathVariable long plantId, @RequestBody CreatePlantRequest updatePlantRequest) {
//        return plantService.updatePlant(plantId, updatePlantRequest);
//    }
//
//    @DeleteMapping("/{plantId}")
//    public void deletePlant(@PathVariable long plantId) {
//        plantService.deletePlant(plantId);
//    }
}
