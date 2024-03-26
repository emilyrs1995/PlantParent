package com.kenzie.capstone.service.caching;

import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.dao.PlantDao;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.util.List;

public class CachingPlantDao implements PlantDao{
    private final CacheClient<String, List<GetPlantListResponse>> cacheClient;
    private final NonCachingPlantDao nonCachingPlantDao;

    public CachingPlantDao(CacheClient<String, List<GetPlantListResponse>> cacheClient, NonCachingPlantDao nonCachingPlantDao) {
        this.cacheClient = cacheClient;
        this.nonCachingPlantDao = nonCachingPlantDao;
    }

    public List<GetPlantListResponse> getPlantList(String query) {
        String cacheKey = generateCacheKey(query);

        List<GetPlantListResponse> cachedResult = cacheClient.get(cacheKey);
        if (cachedResult != null) {
            return cachedResult;
        }

        List<GetPlantListResponse> result = nonCachingPlantDao.getPlantList(query);

        cacheClient.put(cacheKey, result);

        return result;
    }

    @Override
    public GetPlantDetailsResponse getPlantDetails(String id) {
        return nonCachingPlantDao.getPlantDetails(id);
    }

    private String generateCacheKey(String query) {
        return "PlantList_" + query;
    }
}
