package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponse {
    @JsonProperty("data")
    private List<Data> data;
    @JsonProperty("to")
    private Integer to;
    @JsonProperty("per_page")
    private Integer per_page;
    @JsonProperty("current_page")
    private Integer current_page;
    @JsonProperty("from")
    private Integer from;
    @JsonProperty("last_page")
    private Integer last_page;
    @JsonProperty("total")
    private Integer total;

    public ApiResponse() {
    }

    public ApiResponse(List<Data> data, Integer to, Integer per_page, Integer current_page, Integer from,
                       Integer last_page, Integer total) {
        this.data = data;
        this.to = to;
        this.per_page = per_page;
        this.current_page = current_page;
        this.from = from;
        this.last_page = last_page;
        this.total = total;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(Integer current_page) {
        this.current_page = current_page;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getLast_page() {
        return last_page;
    }

    public void setLast_page(Integer last_page) {
        this.last_page = last_page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
