package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetPlantListApiResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("common_name")
    private String common_name;
    @JsonProperty("scientific_name")
    private List<String> scientific_name;
    @JsonProperty("other_name")
    private List<String> other_name;
    @JsonProperty("cycle")
    private String cycle;
    @JsonProperty("watering")
    private String watering;
    @JsonProperty("sunlight")
    private List<String> sunlight;
    @JsonProperty("default_image")
    private DefaultImage default_image;

    public GetPlantListApiResponse() {
    }

    public GetPlantListApiResponse(Integer id, String common_name, List<String> scientific_name,
                                   List<String> other_name, String cycle, String watering, List<String> sunlight,
                                   DefaultImage default_image) {
        this.id = id;
        this.common_name = common_name;
        this.scientific_name = scientific_name;
        this.other_name = other_name;
        this.cycle = cycle;
        this.watering = watering;
        this.sunlight = sunlight;
        this.default_image = default_image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommon_name() {
        return common_name;
    }

    public void setCommon_name(String common_name) {
        this.common_name = common_name;
    }

    public List<String> getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(List<String> scientific_name) {
        this.scientific_name = scientific_name;
    }

    public List<String> getOther_name() {
        return other_name;
    }

    public void setOther_name(List<String> other_name) {
        this.other_name = other_name;
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

    public List<String> getSunlight() {
        return sunlight;
    }

    public void setSunlight(List<String> sunlight) {
        this.sunlight = sunlight;
    }

    public DefaultImage getDefaultImage() {
        return default_image;
    }

    public void setDefaultImage(DefaultImage default_image) {
        this.default_image = default_image;
    }
}
