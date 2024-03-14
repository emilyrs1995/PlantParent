package com.kenzie.appserver.service;

import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantResponse;
import com.kenzie.appserver.converter.PlantResponseConverter;
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

    /**
     * getPlantListByName - calls the PlantListLambdaServiceClient.getPlantList which in turn sends the requests to
     * the Lambda and external API. PlantListLambdaServiceClient.getPlantList returns a list of GetPlantListResponses
     * which we then convert to our PlantResponse to send back to the frontend.
     * @param plantName the name of the plant that we're sending to the external API.
     * @return List<PlantResponse>
     */
    public List<PlantResponse> getPlantListByName(String plantName) {
        List<GetPlantListResponse> lambdaResponses = plantListLambdaServiceClient.getPlantList(plantName);

        return Optional.ofNullable(lambdaResponses)
                .orElse(Collections.emptyList())
                .stream()
                .map(PlantResponseConverter::convertFromGetPlantListResponseToPlantResponse)
                .collect(Collectors.toList());
    }

    /**
     * createPlant - takes in a CreatePlantRequest and saves it to out table. Our method then converts the request into
     * a PlantResponse and returns it.
     * @param request the CreatePlantRequest that we receive from the controller.
     * @return PlantResponse
     */
    public PlantResponse createPlant(CreatePlantRequest request) {
        PlantRecord record = this.convertToRecord(request);
        plantRepository.save(record);

        return PlantResponseConverter.convertFromCreatePlantRequestToPlantResponse(request);
    }

    /**
     * findAll - Calls the PlantRepository.findAll() method and returns all the plants that have been saved in our table.
     * @return List<PlantResponse>
     */
    public List<PlantResponse> findAll() {
        List<PlantResponse> plants = new ArrayList<>();

        Iterable<PlantRecord> plantIterator = plantRepository.findAll();
        for (PlantRecord record : plantIterator) {
            plants.add(PlantResponseConverter.convertFromRecordToPlantResponse(record));
        }

        return plants;
    }

    /**
     * findByName - takes in a plantName, calls the findAll() method and then filters through the responses to find
     * plants that contain the name given as a param and returns those plants.
     * @param plantName the name of the plant(s) we're looking for.
     * @return List<PlantResponse>
     */
    public List<PlantResponse> findByName(String plantName) {
        List<PlantResponse> allPlants = this.findAll();

        return Optional.ofNullable(allPlants)
                .orElse(Collections.emptyList())
                .stream()
                .filter(plantResponse -> plantResponse.getPlantName().contains(plantName))
                .collect(Collectors.toList());
    }

    /**
     * delete - takes an id as a param and calls the PlantRepository.deleteById() method to delete the plant saved with
     * that id.
     * @param id the id of the plant we are trying to delete.
     */
    public void delete(String id) {
        plantRepository.deleteById(id);
    }

    /**
     * convertToRecord - a private method that takes in a CreatePlantRequest as a param and converts to a PlantRecord
     * and then returns that record.
     * @param request the CreatePlantRequest that we're trying to convert.
     * @return PlantRecord
     */
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

}

