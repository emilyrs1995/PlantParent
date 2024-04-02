package com.kenzie.capstone.service.caching;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.dao.PlantDao;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class CachingPlantDao implements PlantDao{
    private final CacheClient<String, String> cacheClient;
    private final NonCachingPlantDao nonCachingPlantDao;

    GsonBuilder builder = new GsonBuilder().registerTypeAdapter(
            ZonedDateTime.class,
            new TypeAdapter<ZonedDateTime>() {
                @Override
                public void write(JsonWriter out, ZonedDateTime value) throws IOException {
                    out.value(value.toString());
                }
                @Override
                public ZonedDateTime read(JsonReader in) throws IOException {
                    return ZonedDateTime.parse(in.nextString());
                }
            }
    ).enableComplexMapKeySerialization();
    Gson gson = builder.create();

    @Inject
    public CachingPlantDao(CacheClient<String, String> cacheClient, NonCachingPlantDao nonCachingPlantDao) {
        this.cacheClient = cacheClient;
        this.nonCachingPlantDao = nonCachingPlantDao;
    }

    @Override
    public List<GetPlantListResponse> getPlantList(String plantName) {
        String cacheKey = plantListCacheKey(plantName);

        String cachedResult = cacheClient.get(cacheKey);
        if (cachedResult != null) {
            return toPlantListResponse(cachedResult);
        }

        List<GetPlantListResponse> result = nonCachingPlantDao.getPlantList(plantName);

        cacheClient.put(cacheKey, toJsonFromPlantListResponse(result));

        return result;
    }

    @Override
    public GetPlantDetailsResponse getPlantDetails(String id) {
        String cacheKey = plantDetailsCacheKey(id);

        String cachedResult = cacheClient.get(cacheKey);
        if (cachedResult != null) {
            return toPlantDetailsResponse(cachedResult);
        }

        GetPlantDetailsResponse result = nonCachingPlantDao.getPlantDetails(id);

        cacheClient.put(cacheKey, toJsonFromPlantDetailsResponse(result));

        return result;
    }

    // GetPlantList() helper methods
    private List<GetPlantListResponse> toPlantListResponse(String json) {
        return gson.fromJson(json, new TypeToken<ArrayList<GetPlantListResponse>>() { }.getType());
    }

    private String toJsonFromPlantListResponse(List<GetPlantListResponse> responses) {
        return gson.toJson(responses);
    }

    private String plantListCacheKey(String plantName) {
        return String.format("PlantList::%s", plantName);
    }


    // GetPlantDetails() helper methods
    private String plantDetailsCacheKey(String plantId) {
        return String.format("PlantDetails::%s", plantId);
    }

    private GetPlantDetailsResponse toPlantDetailsResponse(String json) {
        return gson.fromJson(json, new TypeToken<GetPlantDetailsResponse>() { }.getType());
    }

    private String toJsonFromPlantDetailsResponse(GetPlantDetailsResponse response) {
        return gson.toJson(response);
    }
}
