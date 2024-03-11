package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;
import java.util.Objects;

@DynamoDBTable(tableName = "PlantCollection")
public class PlantRecord {
    private String plantId;
    private String plantName;
    private List<String> scientificName;
    private String cycle;
    private String watering;
    private String sunlight;
    private String imgUrl;

    @DynamoDBHashKey(attributeName = "Id")
    public String getPlantId() {
        return plantId;
    }

    @DynamoDBAttribute(attributeName = "PlantName")
    public String getPlantName() {
        return plantName;
    }

    @DynamoDBAttribute(attributeName = "ScientificName")
    public List<String> getScientificName() {
        return scientificName;
    }

    @DynamoDBAttribute(attributeName = "Cycle")
    public String getCycle() {
        return cycle;
    }

    @DynamoDBAttribute(attributeName = "Watering")
    public String getWatering() {
        return watering;
    }

    @DynamoDBAttribute(attributeName = "Sunlight")
    public String getSunlight() {
        return sunlight;
    }

    @DynamoDBAttribute(attributeName = "ImgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setScientificName(List<String> scientificName) {
        this.scientificName = scientificName;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public void setSunlight(String sunlight) {
        this.sunlight = sunlight;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantRecord that = (PlantRecord) o;
        return Objects.equals(plantId, that.plantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plantId);
    }
}
