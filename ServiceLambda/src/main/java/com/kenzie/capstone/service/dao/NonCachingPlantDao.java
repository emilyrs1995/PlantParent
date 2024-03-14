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
        //return this.mockingGettingTwoValidResponsesAndOneInvalidResponseFromTheAPI();


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


    /**
     * mockingGettingOneResponseFromTheAPI - this is a method mocking converting one response from the external
     * API and seeing if our mapper reads everything okay and that our converter methods are working as expected.
     * Uncomment line 37 and run the "getPlantListSuccessful_withOneValidPlant_successful" test in
     * PlantListLambdaServiceTest to run this method. (please make sure to comment out the actual call to the API first)
     * @return List<GetPlantListResponse>
     */
    private List<GetPlantListResponse> mockingGettingOneResponseFromTheAPI() {
        String responseFromMock = MockingAPI.giveMeOneResponse();
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

    /**
     * mockingGettingFiveResponsesFromTheAPI - this is a method mocking converting five responses from the external
     * API and seeing if our mapper reads everything okay and that our converter methods are working as expected.
     * Uncomment line 38 and run the "getPlantList_withFiveValidPlants_successful" test in PlantListLambdaServiceTest
     * to run this method. (please make sure to comment out the actual call to the API first)
     * @return List<GetPlantListResponse>
     */
    private List<GetPlantListResponse> mockingGettingFiveResponsesFromTheAPI() {
        String responseFromMock = MockingAPI.giveMeFiveResponses();
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


    /**
     * mockingGettingTwoValidResponsesAndOneInvalidResponseFromTheAPI - this is a method mocking converting two valid
     * responses and one invalid response from the external API and seeing if our mapper reads everything okay and that
     * our converter methods are working as expected. Most of all we're checking to see if the invalid API response is
     * filtered out and not returned as a GetPlantListResponse.
     * THIS METHOD DOES NOT WORK YET!!
     * @return List<GetPlantListResponse>
     */
    private List<GetPlantListResponse> mockingGettingTwoValidResponsesAndOneInvalidResponseFromTheAPI() {
        String responseFromMock = MockingAPI.giveMeTwoValidAndOneInvalidResponse();
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
