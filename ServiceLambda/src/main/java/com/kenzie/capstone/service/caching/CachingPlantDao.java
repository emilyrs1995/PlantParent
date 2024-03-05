package com.kenzie.capstone.service.caching;

import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.dao.PlantDao;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.util.List;

public class CachingPlantDao implements PlantDao {

    private final CacheClient cacheClient;
    private final NonCachingPlantDao plantDao;

    @Inject
    public CachingPlantDao(CacheClient cacheClient, NonCachingPlantDao plantDao) {
        this.cacheClient = cacheClient;
        this.plantDao = plantDao;
    }

    @Override
    public List<GetPlantListResponse> getPlantList(String plantName) {
        return null;
    }
}
