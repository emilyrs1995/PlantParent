package com.kenzie.capstone.service.converter;

import com.kenzie.capstone.service.model.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

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
            LinkedHashMap<String, String> hashmap = (LinkedHashMap<String, String>) apiDetailsResponse.getHardiness().get();

            Hardiness hardiness = new Hardiness();
            hardiness.setMin(hashmap.get("min"));
            hardiness.setMax(hashmap.get("max"));
            getPlantDetailsResponse.setHardinessZone(hardiness.toString());
        } else {
            getPlantDetailsResponse.setHardinessZone("Unknown");
        }

        if (apiDetailsResponse.getWateringGeneralBenchmark().isPresent()) {
            LinkedHashMap<String, String> hashmap = (LinkedHashMap<String, String>) apiDetailsResponse.getWateringGeneralBenchmark().get();

            WateringGeneralBenchmark benchmark = new WateringGeneralBenchmark();
            benchmark.setUnit(hashmap.get("unit"));
            benchmark.setValue(hashmap.get("value"));
            getPlantDetailsResponse.setWateringBenchmark(benchmark.toString());
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

        if (apiDetailsResponse.getScientificName().isPresent()) {
            getPlantDetailsResponse.setScientificName((List<String>) apiDetailsResponse.getScientificName().get());
        } else {
            getPlantDetailsResponse.setScientificName(Collections.emptyList());
        }

        if (apiDetailsResponse.getCycle().isPresent()) {
            getPlantDetailsResponse.setCycle(apiDetailsResponse.getCycle().get());
        } else {
            getPlantDetailsResponse.setCycle("Unknown");
        }

        if (apiDetailsResponse.getSunlight().isPresent()) {
            List<String> sunlight = (List<String>) apiDetailsResponse.getSunlight().get();
            getPlantDetailsResponse.setSunlight(sunlight.get(0));
        } else {
            getPlantDetailsResponse.setSunlight("Unknown");
        }

        if (apiDetailsResponse.getWatering().isPresent()) {
            getPlantDetailsResponse.setWatering(apiDetailsResponse.getWatering().get());
        } else {
            getPlantDetailsResponse.setWatering("Unknown");
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

        if (apiDetailsResponse.getDefaultImage().isPresent()) {
            LinkedHashMap<String, String> hashmap = (LinkedHashMap<String, String>) apiDetailsResponse.getDefaultImage().get();
            String imgUrl = hashmap.get("regular_url");
            getPlantDetailsResponse.setIMGUrl(imgUrl);
        }

        if (apiDetailsResponse.isFlowers().isPresent() && apiDetailsResponse.isFlowers().get() && apiDetailsResponse.getFlowerColor().isPresent()) {
            getPlantDetailsResponse.setFlowerColor(apiDetailsResponse.getFlowerColor().get());
        } else {
            getPlantDetailsResponse.setFlowerColor(String.format("The %s plant does not have flowers.", apiDetailsResponse.getCommonName().get()));
        }

        return getPlantDetailsResponse;
    }
}
