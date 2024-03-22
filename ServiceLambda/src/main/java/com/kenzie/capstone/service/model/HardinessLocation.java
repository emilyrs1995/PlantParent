package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HardinessLocation {
    @JsonProperty("full_iframe")
    private String fullIframe;
    @JsonProperty("full_url")
    private String fullUrl;

    public String getFullIframe() {
        return fullIframe;
    }

    public void setFullIframe(String fullIframe) {
        this.fullIframe = fullIframe;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }
}
