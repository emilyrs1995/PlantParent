package com.kenzie.capstone.service.model;

import java.util.List;

public class GetPlantListApiResponse {

    private Integer id;
    private String common_name;
    private List<String> scientific_name;
    private List<String> other_name;
    private String cycle;
    private String watering;
    private String sunlight;
    private DefaultImage defaultImage;

    public GetPlantListApiResponse() {
    }

    public GetPlantListApiResponse(Integer id, String common_name, List<String> scientific_name,
                                   List<String> other_name, String cycle, String watering, String sunlight,
                                   DefaultImage defaultImage) {
        this.id = id;
        this.common_name = common_name;
        this.scientific_name = scientific_name;
        this.other_name = other_name;
        this.cycle = cycle;
        this.watering = watering;
        this.sunlight = sunlight;
        this.defaultImage = defaultImage;
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

    public String getSunlight() {
        return sunlight;
    }

    public void setSunlight(String sunlight) {
        this.sunlight = sunlight;
    }

    public DefaultImage getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(DefaultImage defaultImage) {
        this.defaultImage = defaultImage;
    }
}
