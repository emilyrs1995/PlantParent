package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetPlantListResponse {
    @JsonProperty("plantId")
    private int plantId;
    @JsonProperty("plantName")
    private String plantName;
    @JsonProperty("scientificName")
    private List<String> scientificName;
    @JsonProperty("cycle")
    private String cycle;
    @JsonProperty("watering")
    private String watering;
    @JsonProperty("sunlight")
    private String sunlight;
    @JsonProperty("IMGUrl")
    private String IMGUrl;

    public GetPlantListResponse(int plantId, String plantName, List<String> scientificName, String cycle, String watering,
                                String sunlight, String IMGUrl) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.cycle = cycle;
        this.watering = watering;
        this.sunlight = sunlight;
        this.IMGUrl = IMGUrl;
    }

    public GetPlantListResponse() {
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public List<String> getScientificName() {
        return scientificName;
    }

    public void setScientificName(List<String> scientificName) {
        this.scientificName = scientificName;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public String getSunlight() {
        return sunlight;
    }

    public void setSunlight(String sunlight) {
        this.sunlight = sunlight;
    }

    public String getIMGUrl() {
        return IMGUrl;
    }

    public void setIMGUrl(String IMGUrl) {
        this.IMGUrl = IMGUrl;
    }

    @Override
    public String toString() {
        return "GetPlantListResponse {" +
                "PlantId = '" + plantId + '\'' +
                ", PlantName = '" + plantName + '\'' +
                ", Cycle = '" + cycle + '\'' +
                ", Watering = '" + watering + '\'' +
                ", Sunlight = '" + sunlight + '\'' +
                ", IMGUrl = '" + IMGUrl +
                "'}";
    }
}
