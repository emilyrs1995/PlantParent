package com.kenzie.capstone.service.converter;

import com.kenzie.capstone.service.model.ApiDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;

public class APIDetailsResponseToGetPlantDetailsResponse {

    public static GetPlantDetailsResponse convertToGetPlantDetailsResponse(ApiDetailsResponse apiDetailsResponse) {
        GetPlantDetailsResponse getPlantDetailsResponse = new GetPlantDetailsResponse();

        if (apiDetailsResponse.getId().isPresent()) {
            getPlantDetailsResponse.setPlantId(apiDetailsResponse.getId().get().toString());
        }

        if (apiDetailsResponse.isIndoor().isPresent()) {
            getPlantDetailsResponse.setIndoor(apiDetailsResponse.isIndoor().get().toString());
        } else {
            getPlantDetailsResponse.setIndoor("Unknown");
        }

        if (apiDetailsResponse.getHardiness().isPresent()) {
            getPlantDetailsResponse.setHardinessZone(apiDetailsResponse.getHardiness().get().toString());
        } else {
            getPlantDetailsResponse.setHardinessZone("Unknown");
        }

        if (apiDetailsResponse.getWateringGeneralBenchmark().isPresent()) {
            getPlantDetailsResponse.setWateringBenchmark(apiDetailsResponse.getWateringGeneralBenchmark().get().toString());
        } else {
            getPlantDetailsResponse.setWateringBenchmark("Unknown");
        }

        if (apiDetailsResponse.isMedicinal().isPresent()) {
            getPlantDetailsResponse.setMedicinal(apiDetailsResponse.isMedicinal().get().toString());
        } else {
            getPlantDetailsResponse.setMedicinal("Unknown");
        }

        if (apiDetailsResponse.getCommonName().isPresent()) {
            getPlantDetailsResponse.setPlantName(apiDetailsResponse.getCommonName().get());
        } else {
            getPlantDetailsResponse.setPlantName("Unknown");
        }

        if (apiDetailsResponse.getMaintenance().isPresent()) {
            getPlantDetailsResponse.setMaintenance(apiDetailsResponse.getMaintenance().get());
        } else {
            getPlantDetailsResponse.setMaintenance("Unknown");
        }

        if (apiDetailsResponse.getCareLevel().isPresent()) {
            getPlantDetailsResponse.setCareLevel(apiDetailsResponse.getCareLevel().get());
        } else {
            getPlantDetailsResponse.setCareLevel("Unknown");
        }

        if (apiDetailsResponse.getGrowthRate().isPresent()) {
            getPlantDetailsResponse.setGrowthRate(apiDetailsResponse.getGrowthRate().get());
        } else {
            getPlantDetailsResponse.setGrowthRate("Unknown");
        }

        if (apiDetailsResponse.getDescription().isPresent()) {
            getPlantDetailsResponse.setDescription(apiDetailsResponse.getDescription().get());
        } else {
            getPlantDetailsResponse.setDescription("Unknown");
        }

        if (apiDetailsResponse.isFlowers().isPresent() && apiDetailsResponse.isFlowers().get() && apiDetailsResponse.getFlowerColor().isPresent()) {
            getPlantDetailsResponse.setFlowerColor(apiDetailsResponse.getFlowerColor().get());
        } else {
            getPlantDetailsResponse.setFlowerColor(String.format("The %s plant does not have flowers.", apiDetailsResponse.getCommonName()));
        }

        return getPlantDetailsResponse;
    }
}
