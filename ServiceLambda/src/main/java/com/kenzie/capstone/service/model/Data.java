package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("common_name")
    private String common_name;
    @JsonProperty("scientific_name")
    private Object scientific_name;
    @JsonProperty("other_name")
    private Object other_name;
    @JsonProperty("cycle")
    private String cycle;
    @JsonProperty("watering")
    private String watering;
    @JsonProperty("sunlight")
    private Object sunlight;
    @JsonProperty("default_image")
    private DefaultImage default_image;

    public Data() {
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

    public Object getScientific_name() {
        return scientific_name;
    }

    public void setScientific_name(Object scientific_name) {
        this.scientific_name = scientific_name;
    }

    public Object getOther_name() {
        return other_name;
    }

    public void setOther_name(Object other_name) {
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

    public Object getSunlight() {
        return sunlight;
    }

    public void setSunlight(Object sunlight) {
        this.sunlight = sunlight;
    }

    public DefaultImage getDefaultImage() {
        return default_image;
    }

    public void setDefaultImage(DefaultImage default_image) {
        this.default_image = default_image;
    }

    @Override
    public String toString() {
        return "Data {" +
                "id=" + id +
                ", common_name='" + common_name + '\'' +
                ", scientific_name=" + scientific_name +
                ", other_name=" + other_name +
                ", cycle='" + cycle + '\'' +
                ", watering='" + watering + '\'' +
                ", sunlight=" + sunlight +
                '}';
    }
}
