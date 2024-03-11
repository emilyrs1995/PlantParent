package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlantResponse {

    @JsonProperty("plantId")
    private String plantId;
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
    @JsonProperty("imgUrl")
    private String imgUrl;

    public PlantResponse() {
    }

    public PlantResponse(String plantId, String plantName, List<String> scientificName, String cycle, String watering, String sunlight, String imgUrl) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.cycle = cycle;
        this.watering = watering;
        this.sunlight = sunlight;
        this.imgUrl = imgUrl;
    }

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
