package com.kenzie.appserver.controller;


import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.CreatePlantResponse;
import com.kenzie.appserver.repositories.model.Plant;
import com.kenzie.appserver.service.PlantService;
import com.kenzie.appserver.service.model.PlantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;
//    @GetMapping("/{id}")
//    public ResponseEntity<CreatePlantResponse> get(@PathVariable("id") String id) {
//        PlantDTO plantDTO = plantService.findByPlantId(id);
//        if (plantDTO != null) {
//            CreatePlantResponse createPlantResponse = buildCreatePlantResponse(plantDTO);
//            return ResponseEntity.ok(createPlantResponse);
//        }
//        return ResponseEntity.notFound().build();
//    }
//    private CreatePlantResponse buildCreatePlantResponse(PlantDTO plantDTO) {
//        CreatePlantResponse createPlantResponse = new CreatePlantResponse(
//        createPlantResponse.setPlantName(plantDTO.getPlantName()),
//        createPlantResponse.setWatering(plantDTO.getWatering()),
//        createPlantResponse.setCycle(plantDTO.getCycle()),
//        createPlantResponse.setSunlight(plantDTO.getSunlight()),
//        createPlantResponse.setImgUrl(plantDTO.getImgurl()),
//        createPlantResponse.setPlantID(plantDTO.getPlantId()));
//        return createPlantResponse;
//    }
//    @PostMapping
//    public ResponseEntity<CreatePlantResponse> addNewPlant(@RequestBody CreatePlantRequest createPlantRequest) {
//        PlantDTO plantDTO = new PlantDTO();
//        plantDTO.setPlantName(createPlantRequest.getPlantName());
//        plantDTO.setCycle(createPlantRequest.getCycle());
//        plantDTO.setImgurl(createPlantRequest.getImgUrl());
//        plantDTO.setWatering(createPlantRequest.getWatering());
//        plantDTO.setSunlight(createPlantRequest.getSunlight());
//        PlantDTO createdPlantDTO = plantService.createPlant(plantDTO);
//        CreatePlantResponse createPlantResponse = buildCreatePlantResponse(createdPlantDTO);
//        return ResponseEntity.ok(createPlantResponse);
//    }
//    //delete obj
//    @GetMapping
//    public ResponseEntity<GetPlantListResponse> findAll() {
//        List<PlantDTO> plantsDTO = plantService.findAll();
//        List<CreatePlantResponse> plants = plantsDTO.stream().map(plantDTO ->  buildCreatePlantResponse(plantDTO)).collect(Collectors.toList());
//        GetPlantListResponse response = new GetPlantListResponse();
//        response.setPlants(plants);
//        return ResponseEntity.ok(response);
//    }
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") String id) {
//        plantService.delete(id);
//    }
//    // changing DTO - received by service - via mapping to response - to send it to screen
//    @GetMapping("/{name}")
//    public ResponseEntity<CreatePlantResponse> findByName(@PathVariable("name") String name) {
//        PlantDTO plantDTO = plantService.findByName(name);
//        if (plantDTO != null) {
//            CreatePlantResponse createPlantResponse = buildCreatePlantResponse(plantDTO);
//            return ResponseEntity.ok(createPlantResponse);
//        }
//        return ResponseEntity.notFound().build();
//        //
//    }
}
