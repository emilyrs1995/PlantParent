package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WateringGeneralBenchmark {
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("value")
    private String value;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Every " + value + " " + unit;
    }
}
