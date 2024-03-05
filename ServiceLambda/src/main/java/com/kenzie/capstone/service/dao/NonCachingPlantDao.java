package com.kenzie.capstone.service.dao;

import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class NonCachingPlantDao implements PlantDao {

    private static final String apiEndpoint = "https://perenual.com/api/species-list";
    private final String apiKey = "?key=sk-mrgS65e66042716974370";
    private final String query = "&q=";

    @Inject
    public NonCachingPlantDao() {
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


        // TODO figure out how to do this
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return convertToGetPlantListResponse(httpResponse.body());
            } else {
                //throw new ApiGatewayException("GET request failed: " + statusCode + " status code received"
                //        + "\n body: " + httpResponse.body());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        // only returning null for now because I'm not 100% sure how to finish this method yet
        return null;
    }

    private List<GetPlantListResponse> convertToGetPlantListResponse(String httpResponse) {
        return null;

    }

}
