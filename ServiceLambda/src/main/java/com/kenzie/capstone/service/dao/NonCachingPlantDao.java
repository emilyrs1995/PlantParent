package com.kenzie.capstone.service.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.capstone.service.exceptions.ApiGatewayException;
import com.kenzie.capstone.service.model.GetPlantListApiResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NonCachingPlantDao implements PlantDao {

    private static final String apiEndpoint = "https://perenual.com/api/species-list";
    private final String apiKey = "?key=sk-mrgS65e66042716974370";
    private final String query = "&q=";

    private ObjectMapper mapper;

    @Inject
    public NonCachingPlantDao() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<GetPlantListResponse> getPlantList(String plantName) {
        String url = apiEndpoint + apiKey + query + plantName;

        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                List<GetPlantListApiResponse> apiResponseList = this.convertFromStringToApiResponse(httpResponse.body());

                return apiResponseList.stream()
                        .map(this::convertFromApiResponse)
                        .collect(Collectors.toList());

            } else {
                throw new ApiGatewayException("GET plant list request failed: " + statusCode + " status code received"
                        + "\n body: " + httpResponse.body());
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    private List<GetPlantListApiResponse> convertFromStringToApiResponse(String httpResponse) {
        try {
            return Collections.singletonList(mapper.readValue(httpResponse, GetPlantListApiResponse.class));
        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }

    }

    private GetPlantListResponse convertFromApiResponse(GetPlantListApiResponse apiResponse) {
        GetPlantListResponse response = new GetPlantListResponse();
        response.setPlantId(apiResponse.getId());
        response.setPlantName(apiResponse.getCommon_name());
        response.setScientificName(apiResponse.getScientific_name());
        response.setCycle(apiResponse.getCycle());
        response.setWatering(apiResponse.getWatering());
        response.setSunlight(apiResponse.getSunlight());

        // this can be changed if we want a different picture for the frontend
        response.setIMGUrl(apiResponse.getDefaultImage().getThumbnail());

        return response;
    }
}
