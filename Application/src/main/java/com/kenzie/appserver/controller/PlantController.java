package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantResponse;
import com.kenzie.appserver.service.PlantService;
import com.kenzie.capstone.service.model.GetPlantListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/plant")
public class PlantController {
    private PlantService plantService;
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/{plantName}")
    public ResponseEntity<List<GetPlantListResponse>> getPlantListByName(@PathVariable("plantName") String plantName) {
        if (plantName == null || plantName.length() == 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Plant Name");
        }

        List<GetPlantListResponse> response = plantService.getPlantListByName(plantName);

        if (response == null || response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/collection")
    public ResponseEntity<PlantResponse> addNewPlant(@RequestBody CreatePlantRequest createPlantRequest) {
        if (createPlantRequest.getPlantId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid PlantId");
        }
        if (createPlantRequest.getPlantName() == null || createPlantRequest.getPlantName().length() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Plant Name");
        }

        PlantResponse response = plantService.createPlant(createPlantRequest);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/collection/all")
    public ResponseEntity<List<PlantResponse>> getPlantCollection() {
        List<PlantResponse> plants = plantService.findAll();

        if (plants == null || plants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(plants);
    }

    @GetMapping("/collection/{plantName}")
    public ResponseEntity<List<PlantResponse>> getPlantByName(@PathVariable("plantName") String plantName) {
        List<PlantResponse> plants = plantService.findByName(plantName);

        if (plants == null || plants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(plants);
    }

    @DeleteMapping("/collection/{id}")
    public ResponseEntity deletePlant(@PathVariable("id") String id) {
        plantService.delete(id);
        return ResponseEntity.ok().build();
    }

}
