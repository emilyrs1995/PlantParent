package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetPlantDetailsResponse {

    @JsonProperty("plantId")
    private String plantId;
    @JsonProperty("plantName")
    private String plantName;
    @JsonProperty("flowerColor")
    private String flowerColor;
    @JsonProperty("maintenance")
    private String maintenance;
    @JsonProperty("careLevel")
    private String careLevel;
    @JsonProperty("growthRate")
    private String growthRate;
    @JsonProperty("indoor")
    private String indoor;
    @JsonProperty("hardinessZone")
    private String hardinessZone;
    @JsonProperty("wateringBenchmark")
    private String wateringBenchmark;
    @JsonProperty("medicinal")
    private String medicinal;
    @JsonProperty("description")
    private String description;

    public GetPlantDetailsResponse() {
    }

    public GetPlantDetailsResponse(String plantId, String plantName, String flowerColor, String maintenance, String careLevel,
                                   String growthRate, String indoor, String hardinessZone, String wateringBenchmark, String medicinal, String description) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.flowerColor = flowerColor;
        this.maintenance = maintenance;
        this.careLevel = careLevel;
        this.growthRate = growthRate;
        this.indoor = indoor;
        this.hardinessZone = hardinessZone;
        this.wateringBenchmark = wateringBenchmark;
        this.medicinal = medicinal;
        this.description = description;
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

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    public String getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(String growthRate) {
        this.growthRate = growthRate;
    }

    public String getIndoor() {
        return indoor;
    }

    public void setIndoor(String indoor) {
        this.indoor = indoor;
    }

    public String getHardinessZone() {
        return hardinessZone;
    }

    public void setHardinessZone(String hardinessZone) {
        this.hardinessZone = hardinessZone;
    }

    public String getWateringBenchmark() {
        return wateringBenchmark;
    }

    public void setWateringBenchmark(String wateringBenchmark) {
        this.wateringBenchmark = wateringBenchmark;
    }

    public String getMedicinal() {
        return medicinal;
    }

    public void setMedicinal(String medicinal) {
        this.medicinal = medicinal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GetPlantDetailsResponse {" +
                "plantId = '" + plantId + '\'' +
                ", plantName = '" + plantName + '\'' +
                ", flowerColor = '" + flowerColor + '\'' +
                ", maintenance = '" + maintenance + '\'' +
                ", careLevel = '" + careLevel + '\'' +
                ", growthRate = '" + growthRate + '\'' +
                ", indoor = '" + indoor + '\'' +
                ", hardinessZone = '" + hardinessZone + '\'' +
                ", wateringBenchmark = '" + wateringBenchmark + '\'' +
                ", medicinal = '" + medicinal + '\'' +
                ", description = '" + description + '\'' +
                '}';
    }
}
