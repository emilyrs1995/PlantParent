package com.kenzie.capstone.service.converter;

import com.kenzie.capstone.service.model.Data;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import java.util.List;

public class DataToGetPlantListResponse {


    /**
     * convertFromDataToGetPlantListResponse - takes a Data object and extracts only the fields we need for our
     * GetPlantListResponse and then returns it.
     * @param data the data from the ApiResponse that we want to convert to the GetPlantListResponse.
     * @return GetPlantListResponse
     */
    public static GetPlantListResponse convertFromDataToGetPlantListResponse(Data data) {
        // returning a new getPlantResponse in case the data is null
        if (data == null) {
            return new GetPlantListResponse();
        }

        GetPlantListResponse response = new GetPlantListResponse();
        response.setPlantId(data.getId());
        response.setPlantName(data.getCommon_name());
        response.setScientificName((List<String>) data.getScientific_name());
        response.setCycle(data.getCycle());
        response.setWatering(data.getWatering());

        // this can be changed if we'd rather have all the sunlight options instead of just the first
        List<String> sunlight = (List<String>) data.getSunlight();
        response.setSunlight(sunlight.get(0));

        // this can be changed if we want a different picture for the frontend
        response.setIMGUrl(data.getDefaultImage().getThumbnail());

        return response;
    }
}
