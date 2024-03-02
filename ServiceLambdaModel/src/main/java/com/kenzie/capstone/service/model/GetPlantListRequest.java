package com.kenzie.capstone.service.model;

public class GetPlantListRequest {
    private String plantName;

    public GetPlantListRequest(String plantName) {
        this.plantName = plantName;
    }

    public GetPlantListRequest() {
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    @Override
    public String toString() {
        return "GetPlantListRequest {" +
                "PlantName = '" + plantName +
                "'}";
    }
}
