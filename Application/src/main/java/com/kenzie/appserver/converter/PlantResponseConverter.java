package com.kenzie.appserver.converter;

import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantResponse;
import com.kenzie.appserver.repositories.model.PlantRecord;
import com.kenzie.capstone.service.model.GetPlantListResponse;

public class PlantResponseConverter {


    /**
     * convertFromCreatePlantRequestToPlantResponse - takes in a CreatePlantRequest as a param and converts it to
     * a PlantResponse and then returns that response.
     * @param createPlantRequest the CreatePlantRequest that we're trying to convert to a PlantResponse.
     * @return PlantResponse
     */
    public static PlantResponse convertFromCreatePlantRequestToPlantResponse(CreatePlantRequest createPlantRequest) {
        PlantResponse response = new PlantResponse();
        response.setPlantId(createPlantRequest.getPlantId());
        response.setPlantName(createPlantRequest.getPlantName());
        response.setScientificName(createPlantRequest.getScientificName());
        response.setCycle(createPlantRequest.getCycle());
        response.setWatering(createPlantRequest.getWatering());
        response.setSunlight(createPlantRequest.getSunlight());
        response.setImgUrl(createPlantRequest.getImgUrl());

        return response;
    }

    /**
     * convertFromRecordToPlantResponse - takes in a PlantRecord as a param and converts it to
     * a PlantResponse and then returns that response.
     * @param plantRecord the PlantRecord that we're trying to convert.
     * @return PlantResponse
     */
    public static PlantResponse convertFromRecordToPlantResponse(PlantRecord plantRecord) {
        PlantResponse response = new PlantResponse();
        response.setPlantId(plantRecord.getPlantId());
        response.setPlantName(plantRecord.getPlantName());
        response.setScientificName(plantRecord.getScientificName());
        response.setCycle(plantRecord.getCycle());
        response.setWatering(plantRecord.getWatering());
        response.setSunlight(plantRecord.getSunlight());
        response.setImgUrl(plantRecord.getImgUrl());

        return response;
    }

    /**
     * convertFromGetPlantListResponseToPlantResponse - takes in a GetPlantListResponse as a param and converts it to
     * a PlantResponse and then returns that response.
     * @param getPlantListResponse the GetPlantListResponse that we're trying to convert
     * @return PlantResponse
     */
    public static PlantResponse convertFromGetPlantListResponseToPlantResponse(GetPlantListResponse getPlantListResponse) {
        PlantResponse response = new PlantResponse();
        response.setPlantId(String.valueOf(getPlantListResponse.getPlantId()));
        response.setPlantName(getPlantListResponse.getPlantName());
        response.setScientificName(getPlantListResponse.getScientificName());
        response.setCycle(getPlantListResponse.getCycle());
        response.setWatering(getPlantListResponse.getWatering());
        response.setSunlight(getPlantListResponse.getSunlight());
        response.setImgUrl(getPlantListResponse.getIMGUrl());

        return response;
    }
}
