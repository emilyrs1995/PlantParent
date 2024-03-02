package com.kenzie.capstone.service.dao;

import com.kenzie.capstone.service.model.GetPlantListResponse;

import java.util.List;

public class NonCachingPlantDao implements PlantDao {


    @Override
    public List<GetPlantListResponse> getPlantList(String plantName) {
        return null;
    }
}
