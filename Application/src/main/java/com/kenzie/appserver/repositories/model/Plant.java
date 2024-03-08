package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Plant")
public class Plant {
    @DynamoDBAttribute(attributeName = "PlantId")
    private String plantId;
    @DynamoDBAttribute(attributeName = "PlantName")
    private String plantName;
    @DynamoDBAttribute(attributeName = "Cycle")
    private String cycle;
    @DynamoDBAttribute(attributeName = "Watering")
    private String watering;
    @DynamoDBAttribute(attributeName = "Sunlight")
    private String sunlight;
    @DynamoDBAttribute(attributeName = "ImgUrl")
    private String imgurl;

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
