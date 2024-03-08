package com.kenzie.appserver.controller.model;

public class GetPlantListResponse {
    private long plantID;
    private String plantName;
    private String cycle;
    private String watering;
    private String sunlight;
    private String imgUrl;

    public GetPlantListResponse(long plantID, String plantName, String cycle, String watering, String sunlight, String imgUrl) {
        this.plantID = plantID;
        this.plantName = plantName;
        this.cycle = cycle;
        this.watering = watering;
        this.sunlight = sunlight;
        this.imgUrl = imgUrl;
    }

    public long getPlantID() {
        return plantID;
    }

    public void setPlantID(long plantID) {
        this.plantID = plantID;
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
