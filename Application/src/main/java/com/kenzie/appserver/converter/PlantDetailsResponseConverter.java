package com.kenzie.appserver.converter;

import com.kenzie.appserver.controller.model.PlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;

public class PlantDetailsResponseConverter {

    public static PlantDetailsResponse convertFromGetPlantDetailsResponseToPlantDetailsResponse(GetPlantDetailsResponse getPlantListResponse) {
        PlantDetailsResponse response = new PlantDetailsResponse();
        response.setPlantId(getPlantListResponse.getPlantId());
        response.setPlantName(getPlantListResponse.getPlantName());
        response.setFlowerColor(getPlantListResponse.getFlowerColor());
        response.setMaintenance(getPlantListResponse.getMaintenance());
        response.setCareLevel(getPlantListResponse.getCareLevel());
        response.setGrowthRate(getPlantListResponse.getGrowthRate());
        response.setIndoor(getPlantListResponse.getIndoor());
        response.setHardinessZone(getPlantListResponse.getHardinessZone());
        response.setWateringBenchmark(getPlantListResponse.getWateringBenchmark());
        response.setMedicinal(getPlantListResponse.getMedicinal());
        response.setDescription(getPlantListResponse.getDescription());

        return response;
    }
}
