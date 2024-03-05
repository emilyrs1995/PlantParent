package com.kenzie.capstone.service.caching;

import com.kenzie.capstone.service.dao.PlantDao;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import java.util.List;

public class CachingPlantDao implements PlantDao {

    @Override
    public List<GetPlantListResponse> getPlantList(String plantName) {
        return null;
    }
}
