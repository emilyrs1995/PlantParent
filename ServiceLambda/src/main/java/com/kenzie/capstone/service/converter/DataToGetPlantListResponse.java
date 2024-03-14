package com.kenzie.capstone.service.converter;

import com.kenzie.capstone.service.model.Data;
import com.kenzie.capstone.service.model.GetPlantListResponse;

public class DataToGetPlantListResponse {

    public static GetPlantListResponse convertFromApiResponse(Data data) {
        // returning a new getPlantResponse in case the data is null
        if (data == null) {
            return new GetPlantListResponse();
        }

        GetPlantListResponse response = new GetPlantListResponse();
        response.setPlantId(data.getId());
        response.setPlantName(data.getCommon_name());
        response.setScientificName(data.getScientific_name());
        response.setCycle(data.getCycle());
        response.setWatering(data.getWatering());

        // this can be changed if we'd rather have all the sunlight options instead of just the first
        response.setSunlight(data.getSunlight().get(0));

        // this can be changed if we want a different picture for the frontend
        response.setIMGUrl(data.getDefaultImage().getThumbnail());

        return response;
    }
}
