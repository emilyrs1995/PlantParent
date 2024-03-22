package com.kenzie.capstone.service.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import java.util.Collections;
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
        String response = endpointUtility.getEndpoint(GET_PLANT_LIST_ENDPOINT.replace("{plantName}", plantName));

        List<GetPlantListResponse> responseList;

        try {
            responseList = Collections.singletonList(mapper.readValue(response, GetPlantListResponse.class));

        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }

        return responseList;
    }

    public GetPlantDetailsResponse getPlantDetails(String id) {
        EndpointUtility endpointUtility = new EndpointUtility();
        String response = endpointUtility.getEndpoint(GET_PLANT_DETAILS_ENDPOINT.replace("{id}", id));

        GetPlantDetailsResponse handlerResponse;

        try {
            handlerResponse = mapper.readValue(response, GetPlantDetailsResponse.class);

        } catch (Exception e) {
            throw new ApiGatewayException("Unable to map deserialize JSON: " + e);
        }

        return handlerResponse;
    }


}
