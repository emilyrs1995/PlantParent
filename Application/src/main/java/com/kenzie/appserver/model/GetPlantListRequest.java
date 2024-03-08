package com.kenzie.appserver.model;

public class GetPlantListRequest {
    private String plantName;
    public GetPlantListRequest(String plantName) {
        this.plantName = plantName;
    }
    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
}
