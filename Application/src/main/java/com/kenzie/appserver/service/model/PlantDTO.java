package com.kenzie.appserver.service.model;

public class PlantDTO {
    private Long plantId;
    private String plantName;
    private String cycle;
    private String watering;
    private String sunlight;
    private String imgurl;
    public long getPlantId() {
        return plantId;
    }
    public void setPlantId(Long plantId) {
        this.plantId = plantId;
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
    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
