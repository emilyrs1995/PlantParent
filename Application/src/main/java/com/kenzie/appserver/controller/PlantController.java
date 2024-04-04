package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantDetailsResponse;
import com.kenzie.appserver.controller.model.PlantResponse;
import com.kenzie.appserver.service.PlantService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/plant")
public class PlantController {
    private PlantService plantService;

    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/list/{plantName}")
    public ResponseEntity<List<PlantResponse>> getPlantListByName(@PathVariable("plantName") String plantName) {
        if (plantName == null || plantName.length() == 0 || !validatePlantName(plantName)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Plant Name");
        }

        List<PlantResponse> response = plantService.getPlantListByName(plantName);

        if (response == null || response.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<PlantDetailsResponse> getPlantDetails(@PathVariable("id") String id) {
        if (id == null || id.length() == 0 || !validateId(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Plant Id");
        }

        PlantDetailsResponse response = plantService.getPlantDetails(id);

        if (response == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/collection")
    public ResponseEntity<PlantResponse> addNewPlant(@RequestBody CreatePlantRequest createPlantRequest) {
        if (createPlantRequest.getPlantId() == null || createPlantRequest.getPlantId().isEmpty()
                || !validateId(createPlantRequest.getPlantId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Plant Id");
        }
        if (createPlantRequest.getPlantName() == null || createPlantRequest.getPlantName().length() == 0
                || !validatePlantName(createPlantRequest.getPlantName())) {
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
        if (plantName == null || plantName.length() == 0 || !validatePlantName(plantName)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Plant Name");
        }

        List<PlantResponse> plants = plantService.findByName(plantName);

        if (plants == null || plants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(plants);
    }

    @DeleteMapping("/collection/delete/{id}")
    public ResponseEntity deletePlant(@PathVariable("id") String id) {
        if (id == null || id.isEmpty() || !validateId(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid PlantId");
        }

        plantService.delete(id);
        List<PlantResponse> plants = plantService.findAll();

        return ResponseEntity.ok(plants);
    }

    /**
     * validateId - checks the id to see if it is between 1 and 3001 (the only ids that are valid for our
     * free tier access to the external API. No id outside of these values should be stored or accessed. Returns true
     * or false.
     * @param id the id that we're checking.
     * @return boolean
     */
    private boolean validateId(String id) {
        try {
            int plantId = Integer.parseInt(id);
            return plantId > 0 && plantId <= 3000;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * validatePlantName - checks the plant name that is coming in from the frontend to make sure it's not longer than
     * 50 characters, is not made up of only white space and only contains letters of the alphabet. Returns true or false.
     * @param name the name that we're checking.
     * @return boolean
     */
    private boolean validatePlantName(String name) {
        if (name.length() > 50) {
            return false;
        }

        String strippedName = name.strip();
        if (strippedName.isEmpty()) {
            return false;
        }

        String allowedStrings = "abcdefghijklmnopqrstupvwxyz ";
        StringBuilder validatedString = new StringBuilder();
        validatedString.append(strippedName.toLowerCase());

        for (int i = 0; i < validatedString.length(); i++) {
            if(!allowedStrings.contains(validatedString.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }
}
