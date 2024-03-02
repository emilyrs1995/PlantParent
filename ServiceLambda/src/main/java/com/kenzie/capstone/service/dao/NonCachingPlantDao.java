package com.kenzie.capstone.service.dao;

import com.kenzie.capstone.service.model.GetPlantListResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.List;

public class NonCachingPlantDao implements PlantDao {

    private static final String api = "https://perenual.com";
    private final String endpoint = "/api/species-list";
    private final String apiKey = "?key=sk-UGjw65dca483b7ddb4370";
    private final String query = "&page=";


    @Override
    public List<GetPlantListResponse> getPlantList(String plantName) {
        // might need to use an Executor service here to search all 300 pages

        String url = api + endpoint + apiKey + query;

        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();


        // more code here

        return null;
    }
}
