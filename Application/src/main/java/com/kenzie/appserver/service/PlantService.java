package com.kenzie.appserver.service;

import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantResponse;
import com.kenzie.appserver.repositories.PlantRepository;
import com.kenzie.appserver.repositories.model.PlantRecord;
import com.kenzie.capstone.service.client.PlantListLambdaServiceClient;
import com.kenzie.capstone.service.model.GetPlantListResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlantService {
    private PlantRepository plantRepository;
    private PlantListLambdaServiceClient plantListLambdaServiceClient;

    public PlantService(PlantRepository repository, PlantListLambdaServiceClient plantListLambdaServiceClient) {
        this.plantRepository = repository;
        this.plantListLambdaServiceClient = plantListLambdaServiceClient;
    }

    public List<GetPlantListResponse> getPlantListByName(String plantName) {
        return plantListLambdaServiceClient.getPlantList(plantName);
    }


    public PlantResponse createPlant(CreatePlantRequest request) {
        PlantRecord record = this.convertToRecord(request);
        plantRepository.save(record);

        PlantResponse response = new PlantResponse();
        response.setPlantId(request.getPlantId());
        response.setPlantName(request.getPlantName());
        response.setScientificName(request.getScientificName());
        response.setCycle(request.getCycle());
        response.setWatering(request.getWatering());
        response.setSunlight(request.getSunlight());
        response.setImgUrl(request.getImgUrl());

        return response;
    }

    public List<PlantResponse> findAll() {
        List<PlantResponse> plants = new ArrayList<>();

        Iterable<PlantRecord> plantIterator = plantRepository.findAll();
        for (PlantRecord record : plantIterator) {
            plants.add(this.convertFromRecordToResponse(record));
        }

        return plants;
    }

    public List<PlantResponse> findByName(String name) {
        List<PlantResponse> allPlants = this.findAll();

        return Optional.ofNullable(allPlants)
                .orElse(Collections.emptyList())
                .stream()
                .filter(plantResponse -> plantResponse.getPlantName().contains(name))
                .collect(Collectors.toList());
    }

    public void delete(String id) {
        plantRepository.deleteById(id);
    }

    private PlantRecord convertToRecord(CreatePlantRequest request) {
        PlantRecord record = new PlantRecord();
        record.setPlantId(request.getPlantId());
        record.setPlantName(request.getPlantName());
        record.setScientificName(request.getScientificName());
        record.setCycle(request.getCycle());
        record.setWatering(request.getWatering());
        record.setSunlight(request.getSunlight());
        record.setImgUrl(request.getImgUrl());

        return record;
    }

    private PlantResponse convertFromRecordToResponse(PlantRecord record) {
        PlantResponse response = new PlantResponse();
        response.setPlantId(record.getPlantId());
        response.setPlantName(record.getPlantName());
        response.setScientificName(record.getScientificName());
        response.setCycle(record.getCycle());
        response.setWatering(record.getWatering());
        response.setSunlight(record.getSunlight());
        response.setImgUrl(record.getImgUrl());

        return response;
    }

}

