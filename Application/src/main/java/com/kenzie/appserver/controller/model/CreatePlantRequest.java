package com.kenzie.appserver.controller.model;

public class CreatePlantRequest {
    private String plantName;
    private String cycle;
    private String watering;
    private String sunlight;
    private String imgUrl;
    public CreatePlantRequest(String plantName, String cycle, String watering, String sunlight, String imgUrl) {
        this.plantName = plantName;
        this.cycle = cycle;
        this.watering = watering;
        this.sunlight = sunlight;
        this.imgUrl = imgUrl;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
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
