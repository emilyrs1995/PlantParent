package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultImage {

    @JsonProperty("license")
    private Integer license;
    @JsonProperty("license_name")
    private String license_name;
    @JsonProperty("license_url")
    private String license_url;
    @JsonProperty("original_url")
    private String original_url;
    @JsonProperty("regular_url")
    private String regular_url;
    @JsonProperty("medium_url")
    private String medium_url;
    @JsonProperty("small_url")
    private String small_url;
    @JsonProperty("thumbnail")
    private String thumbnail;

    public DefaultImage() {
    }

    public Integer getLicense() {
        return license;
    }

    public void setLicense(Integer license) {
        this.license = license;
    }

    public String getLicense_name() {
        return license_name;
    }

    public void setLicense_name(String license_name) {
        this.license_name = license_name;
    }

    public String getLicense_url() {
        return license_url;
    }

    public void setLicense_url(String license_url) {
        this.license_url = license_url;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public String getRegular_url() {
        return regular_url;
    }

    public void setRegular_url(String regular_url) {
        this.regular_url = regular_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public void setMedium_url(String medium_url) {
        this.medium_url = medium_url;
    }

    public String getSmall_url() {
        return small_url;
    }

    public void setSmall_url(String small_url) {
        this.small_url = small_url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
