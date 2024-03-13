package com.kenzie.capstone.service.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.capstone.service.converter.DataToGetPlantListResponse;
import com.kenzie.capstone.service.exceptions.ApiGatewayException;
import com.kenzie.capstone.service.model.Data;
import com.kenzie.capstone.service.model.ApiResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

        //return this.mockingGettingOneResponseFromTheAPI();
        //return this.mockingGettingFiveResponsesFromTheAPI();


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
                ApiResponse apiResponseList = this.convertFromStringToApiResponse(httpResponse.body());

                return Optional.of(apiResponseList.getData())
                        .orElse(Collections.emptyList())
                        .stream()
                        // filtering out all the plants that are beyond our free tier of Api use
                        .filter(apiResponse -> apiResponse.getId() > 3000)
                        // converting and the returning the collection
                        .map(DataToGetPlantListResponse::convertFromApiResponse)
                        // limiting the list to only 5 responses
                        .limit(5)
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

    private ApiResponse convertFromStringToApiResponse(String httpResponse) {
        try {
            return mapper.readValue(httpResponse, ApiResponse.class);
        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }

    }

    private List<GetPlantListResponse> mockingGettingOneResponseFromTheAPI() {
        String responseFromMock = MockingAPI.giveMeAString();
        ApiResponse convertedOnce = convertFromStringToApiResponse(responseFromMock);

        for(Data data : convertedOnce.getData()) {
            System.out.println(data.toString());
        }

        return Optional.of(convertedOnce.getData())
                .orElse(Collections.emptyList())
                .stream()
                .filter(apiResponse -> apiResponse.getId() < 3000)
                .map(DataToGetPlantListResponse::convertFromApiResponse)
                .limit(5)
                .collect(Collectors.toList());
    }

    private List<GetPlantListResponse> mockingGettingFiveResponsesFromTheAPI() {
        String responseFromMock = MockingAPI.giveMeALongerString();
        ApiResponse convertedOnce = convertFromStringToApiResponse(responseFromMock);

        for(Data data : convertedOnce.getData()) {
            System.out.println(data.toString());
        }

        return Optional.of(convertedOnce.getData())
                .orElse(Collections.emptyList())
                .stream()
                .filter(apiResponse -> apiResponse.getId() < 3000)
                .map(DataToGetPlantListResponse::convertFromApiResponse)
                .limit(5)
                .collect(Collectors.toList());
    }

}
