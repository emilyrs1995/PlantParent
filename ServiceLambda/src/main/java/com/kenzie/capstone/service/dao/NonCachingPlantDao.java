package com.kenzie.capstone.service.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.capstone.service.converter.DataToGetPlantListResponse;
import com.kenzie.capstone.service.exceptions.ApiGatewayException;
import com.kenzie.capstone.service.model.ApiResponse;
import com.kenzie.capstone.service.model.Data;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
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
        return this.mockingGettingFiveResponsesFromTheAPI();
        //return this.mockingGettingTwoValidResponsesAndOneInvalidResponseFromTheAPI();


//        String url = apiEndpoint + apiKey + query + plantName;
//
//        HttpClient client = HttpClient.newHttpClient();
//        URI uri = URI.create(url);
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(uri)
//                .header("Accept", "application/json")
//                .GET()
//                .build();
//
//        try {
//            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            int statusCode = httpResponse.statusCode();
//            if (statusCode == 200) {
//                // converting from the String to our ApiResponse object
//                ApiResponse apiResponse = this.convertFromStringToApiResponse(httpResponse.body());
//
//                // validating the data in the ApiResponse. Filtering out any data that has null values or has an id over 3000
//                List<Data> validatedData = this.validateDataFromApiResponse(apiResponse.getData());
//
//                return Optional.of(validatedData)
//                        .orElse(Collections.emptyList())
//                        .stream()
//                        // converting to GetPlantListResponse
//                        .map(DataToGetPlantListResponse::convertFromDataToGetPlantListResponse)
//                        // limiting the list to only 5 responses and then returning the collection
//                        .limit(5)
//                        .collect(Collectors.toList());
//
//            } else {
//                throw new ApiGatewayException("GET plant list request failed: " + statusCode + " status code received"
//                        + "\n body: " + httpResponse.body());
//            }
//
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            return Collections.emptyList();
//        }

    }

    /**
     * convertFromStringToApiResponse - takes in the response from the HttpClient as a param and uses the Object mapper
     * to deserialize the JSON and return the ApiResponse object.
     * @param httpResponse the JSON string we get back from the HttpClient
     * @return ApiResponse
     */
    private ApiResponse convertFromStringToApiResponse(String httpResponse) {
        try {
            return mapper.readValue(httpResponse, ApiResponse.class);
        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }

    }

    /**
     * validateDataFromApiResponse - takes in the list of Data from the ApiResponse and checks for null fields and
     * that the ID is less than 3001. We need these specific fields, and we don't want to send any responses without
     * these necessary fields out to our frontend. After filtering out the Data objects that contain null values we
     * return the List of validated Data objects.
     * @param dataList the List of Data that we're trying to validate.
     * @return List<Data>
     */
    private List<Data> validateDataFromApiResponse(List<Data> dataList) {
        List<Data> goodData = new ArrayList<>();
        for (Data data : dataList) {
            if (data.getId() <= 3000 && data.getId() != null && data.getCommon_name() != null && data.getScientific_name() != null
                    && data.getCycle() != null && data.getSunlight() != null && data.getWatering() != null
                    && data.getDefaultImage().getThumbnail() != null) {
                goodData.add(data);
            }
        }

        return goodData;
    }




    // THESE ARE THE MOCKING METHODS USED TO TEST OUR CONVERSIONS/FRONTEND BEFORE WE ACTUALLY CALL THE EXTERNAL API



    /**
     * mockingGettingOneResponseFromTheAPI - this is a method mocking converting one response from the external
     * API and seeing if our mapper reads everything okay and that our converter methods are working as expected.
     * It calls the MockingApi.giveMeOneResponse() method which returns a JSON String.
     *
     * Uncomment line 38 and run the "getPlantListSuccessful_withOneValidPlant_successful" test in
     * PlantListLambdaServiceTest to run this method. (please make sure to comment out the actual call to the API first)
     * @return List<GetPlantListResponse>
     */
    private List<GetPlantListResponse> mockingGettingOneResponseFromTheAPI() {
        String responseFromMock = MockingAPI.giveMeOneResponse();
        ApiResponse convertedOnce = convertFromStringToApiResponse(responseFromMock);
        List<Data> validatedData = this.validateDataFromApiResponse(convertedOnce.getData());

        return Optional.of(validatedData)
                .orElse(Collections.emptyList())
                .stream()
                .map(DataToGetPlantListResponse::convertFromDataToGetPlantListResponse)
                .limit(5)
                .collect(Collectors.toList());
    }

    /**
     * mockingGettingFiveResponsesFromTheAPI - this is a method mocking converting five responses from the external
     * API and seeing if our mapper reads everything okay and that our converter methods are working as expected.
     * It calls the MockingApi.giveMeFiveResponses() method which returns a JSON String.
     *
     * Uncomment line 39 and run the "getPlantList_withFiveValidPlants_successful" test in PlantListLambdaServiceTest
     * to run this method. (please make sure to comment out the actual call to the API first)
     * @return List<GetPlantListResponse>
     */
    private List<GetPlantListResponse> mockingGettingFiveResponsesFromTheAPI() {
        String responseFromMock = MockingAPI.giveMeFiveResponses();
        ApiResponse convertedOnce = convertFromStringToApiResponse(responseFromMock);
        List<Data> validatedData = this.validateDataFromApiResponse(convertedOnce.getData());

        return Optional.of(validatedData)
                .orElse(Collections.emptyList())
                .stream()
                .map(DataToGetPlantListResponse::convertFromDataToGetPlantListResponse)
                .limit(5)
                .collect(Collectors.toList());
    }


    /**
     * mockingGettingTwoValidResponsesAndOneInvalidResponseFromTheAPI - this is a method mocking converting two valid
     * responses and one invalid response from the external API and seeing if our mapper reads everything okay and that
     * our converter methods are working as expected. Most of all we're checking to see if the invalid API response is
     * filtered out and not returned as a GetPlantListResponse. It calls the MockingApi.giveMeTwoValidAndOneInvalidResponse()
     * method which returns a JSON String.
     *
     * Uncomment line 40 and run the "getPlantList_withTwoValidPlants_andOneInvalid_onlyReturnsValid" test in
     * PlantListLambdaServiceTest to run this method. (please make sure to comment out the actual call to the API first)
     * @return List<GetPlantListResponse>
     */
    private List<GetPlantListResponse> mockingGettingTwoValidResponsesAndOneInvalidResponseFromTheAPI() {
        String responseFromMock = MockingAPI.giveMeTwoValidAndOneInvalidResponse();
        ApiResponse convertedOnce = convertFromStringToApiResponse(responseFromMock);
        List<Data> validatedData = this.validateDataFromApiResponse(convertedOnce.getData());

        return Optional.of(validatedData)
                .orElse(Collections.emptyList())
                .stream()
                .map(DataToGetPlantListResponse::convertFromDataToGetPlantListResponse)
                .limit(5)
                .collect(Collectors.toList());
    }

}
