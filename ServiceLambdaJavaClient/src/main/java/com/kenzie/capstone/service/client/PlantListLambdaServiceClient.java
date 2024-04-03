package com.kenzie.capstone.service.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import java.util.List;

public class PlantListLambdaServiceClient {

    private static final String GET_PLANT_LIST_ENDPOINT = "plants/{plantName}";
    private static final String GET_PLANT_DETAILS_ENDPOINT ="details/{id}";

    private ObjectMapper mapper;

    public PlantListLambdaServiceClient() {
        this.mapper = new ObjectMapper();
    }

    public List<GetPlantListResponse> getPlantList(String plantName) {
        EndpointUtility endpointUtility = new EndpointUtility();
        String response = endpointUtility.getEndpoint(GET_PLANT_LIST_ENDPOINT.replace("{plantName}", this.replaceWhitespace(plantName)));

        List<GetPlantListResponse> responseList;

        try {
            responseList = List.of(mapper.readValue(response, GetPlantListResponse[].class));

        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }

        return responseList;
    }

    public GetPlantDetailsResponse getPlantDetails(String id) {
        EndpointUtility endpointUtility = new EndpointUtility();
        String handlerResponse = endpointUtility.getEndpoint(GET_PLANT_DETAILS_ENDPOINT.replace("{id}", id));

        GetPlantDetailsResponse response;

        try {
            response = mapper.readValue(handlerResponse, GetPlantDetailsResponse.class);

        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }

        return response;
    }

    private String replaceWhitespace(String plantName) {
        return plantName.replace(" ", "%20");
    }
}
