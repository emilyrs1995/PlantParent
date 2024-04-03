package com.kenzie.appserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.kenzie.appserver.IntegrationTest;
import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantDetailsResponse;
import com.kenzie.appserver.controller.model.PlantResponse;
import com.kenzie.appserver.service.PlantService;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@IntegrationTest
public class PlantControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    PlantService plantService;

    private static final ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void setup() {
        mapper.registerModule(new Jdk8Module());
    }


    /** ------------------------------------------------------------------------
     *  plantController.getPlantListByName()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantServiceLambda_getPlantListByName_successful() throws Exception {
        String plantName = "torch";

        ResultActions actions = mvc.perform(get("/plant/list/{plantName}", plantName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        String responseBody = actions.andReturn().getResponse().getContentAsString();
        List<PlantResponse> responseList = List.of(mapper.readValue(responseBody, PlantResponse[].class));

        for (PlantResponse response : responseList) {
            assertThat(response.getPlantId()).isNotEmpty();
            assertThat(response.getPlantName()).isNotEmpty();
            assertThat(response.getCycle()).isNotEmpty();
            assertThat(response.getWatering()).isNotEmpty();
            assertThat(response.getSunlight()).isNotEmpty();
            assertThat(response.getScientificName()).isNotEmpty();
            assertThat(response.getImgUrl()).isNotEmpty();
        }
    }

    @Test
    public void plantServiceLambda_getPlantListByNameWithInvalidName_Unsuccessful() throws Exception {
        // GIVEN
        String invalidName = "4#:<%";

        // WHEN
        mvc.perform(get("/plant/list/{plantName}", invalidName)
                    .accept(MediaType.APPLICATION_JSON))
        // THEN
                .andExpect(status().isBadRequest());
    }

    @Test
    public void plantServiceLambda_getPlantListByName_apiFailure() throws Exception {
        // GIVEN
        String plantName = "spiderplant";

        // WHEN
        mvc.perform(get("/plant/list/{plantName}", plantName)
                    .accept(MediaType.APPLICATION_JSON))
        // THEN
                .andExpect(status().isNoContent());
    }


    /** ------------------------------------------------------------------------
     *  plantController.getPlantDetails()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantServiceLambda_getPlantDetailsWithValidId_successful() throws Exception {
        // GIVEN
        String id = "61";
        String name = "Hogyoku Japanese Maple";
        List<String> scientificName = new ArrayList<>();
        scientificName.add("Acer palmatum 'Hogyoku'");
        String cycle = "Perennial";
        String watering = "Average";
        String sunlight = "full sun";
        String flowerColor = "Reddish-purple";
        String maintenance = "Low";
        String careLevel = "Unknown";
        String growthRate = "Low";
        String indoor = "false";
        String hardinessZone = "7 - 7";
        String wateringBenchmark = "Every 3-4 days";
        String medicinal = "false";
        String imgUrl = "https://perenual.com/storage/species_image/61_acer_palmatum_hogyoku/regular/2560px-Kyoto_Japan0431.jpg";
        String description = "Hogyoku Japanese Maple (Acer palmatum 'Hogyoku') is an amazing plant species noted for its striking beauty. " +
                "Its delicate foliage emerges with a golden hue and develops into a vibrant, deep scarlet during the cooler months. " +
                "Bright red flowers bloom in spring and bring in stunning hues all season long. The foliage turns to yellow, orange, " +
                "and pink in the fall. Outstanding bark color is a nice addition to the landscape - from cinnamon-red to orange and yellow. " +
                "The beauty of tiger-striped bark truly stands out in the winter. Hogyoku is easy to grow and low-maintenance. " +
                "It also does extremely well in containers and makes a stunning accent for any garden.";

        PlantDetailsResponse expectedResponse = new PlantDetailsResponse(id, name, scientificName, cycle, watering, sunlight, flowerColor, maintenance, careLevel,
                growthRate, indoor, hardinessZone, wateringBenchmark, medicinal, description, imgUrl);


        // WHEN
        mvc.perform(get("/plant/details/{id}", id)
                        .accept(MediaType.APPLICATION_JSON))
                // THEN
                .andExpect(jsonPath("plantId")
                        .value(is(id)))
                .andExpect(jsonPath("plantName")
                        .value(is(name)))
                .andExpect(jsonPath("scientificName")
                        .value(is(scientificName)))
                .andExpect(jsonPath("cycle")
                        .value(is(cycle)))
                .andExpect(jsonPath("watering")
                        .value(is(watering)))
                .andExpect(jsonPath("sunlight")
                        .value(is(sunlight)))
                .andExpect(jsonPath("flowerColor")
                        .value(is(flowerColor)))
                .andExpect(jsonPath("maintenance")
                        .value(is(maintenance)))
                .andExpect(jsonPath("careLevel")
                        .value(is(careLevel)))
                .andExpect(jsonPath("growthRate")
                        .value(is(growthRate)))
                .andExpect(jsonPath("indoor")
                        .value(is(indoor)))
                .andExpect(jsonPath("hardinessZone")
                        .value(is(hardinessZone)))
                .andExpect(jsonPath("wateringBenchmark")
                        .value(is(wateringBenchmark)))
                .andExpect(jsonPath("medicinal")
                        .value(is(medicinal)))
                .andExpect(jsonPath("imgUrl")
                        .value(is(imgUrl)))
                .andExpect(jsonPath("description")
                        .value(is(description)))
                .andExpect(status().isOk());
    }

    @Test
    public void plantLambdaService_getPlantDetailsWithInvalidId_unsuccessful() throws Exception {
        // GIVEN
        String invalidId = "-1";

        // WHEN
        mvc.perform(get("/plant/details/{id}", invalidId)
                    .accept(MediaType.APPLICATION_JSON))
        // THEN
                .andExpect(status().isBadRequest());
    }


    /** ------------------------------------------------------------------------
     *  plantController.addNewPlant()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantController_addNewPlant_successful() throws Exception {
        CreatePlantRequest request = new CreatePlantRequest();
        request.setCycle("annual");
        request.setImgUrl("image");
        request.setSunlight("Medium Sun");
        request.setWatering("3 times a week");
        List<String> scientificNames = Arrays.asList("Oak", "Green Oak");
        request.setScientificName(scientificNames);
        request.setPlantName("Loving Daisy");

        mvc.perform(post("/plant/collection")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.plantId").exists())
                .andExpect(jsonPath("$.cycle").value(request.getCycle()))
                .andExpect(jsonPath("$.imgUrl").value(request.getImgUrl()))
                .andExpect(jsonPath("$.sunlight").value(request.getSunlight()))
                .andExpect(jsonPath("$.watering").value(request.getWatering()))
                .andExpect(jsonPath("$.scientificName").value(request.getScientificName()))
                .andExpect(jsonPath("$.plantName").value(request.getPlantName()));

    }

    @Test
    public void plantController_addNewPlantWithNullFields_unsuccessful() throws Exception {
        CreatePlantRequest request = new CreatePlantRequest();
        mvc.perform(post("/plant/collection")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());


    }


    /** ------------------------------------------------------------------------
     *  plantController.getPlantCollection()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantController_getPlantCollection_successful() throws Exception {
        String id1 = "1";
        String name1 = "aloe";
        List<String> scientificName1 = new ArrayList<>();
        scientificName1.add("fancy aloe");
        String cycle1 = "perennial";
        String watering1 = "average";
        String sunlight1 = "full sun";
        String imgUrl1 = "image";
        CreatePlantRequest request1 = new CreatePlantRequest(id1, name1, scientificName1, cycle1, watering1, sunlight1, imgUrl1);
        PlantResponse persistedResponse1 = plantService.createPlant(request1);

        String id2 = "2";
        String name2 = "spider plant";
        List<String> scientificName2 = new ArrayList<>();
        scientificName2.add("fancy spider plant");
        String cycle2 = "perennial";
        String watering2 = "average";
        String sunlight2 = "full sun";
        String imgUrl2 = "image";
        CreatePlantRequest request2 = new CreatePlantRequest(id2, name2, scientificName2, cycle2, watering2, sunlight2, imgUrl2);
        PlantResponse persistedResponse2 = plantService.createPlant(request2);

        String mvcResponse = mvc.perform(get("/plant/collection/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<PlantResponse> responseList = List.of(mapper.readValue(mvcResponse, PlantResponse[].class));

        for (PlantResponse response : responseList) {
            if (response.getPlantId().equals(id1)) {
                Assertions.assertEquals(response.getPlantName(), persistedResponse1.getPlantName());
                Assertions.assertEquals(response.getScientificName(), persistedResponse1.getScientificName());
                Assertions.assertEquals(response.getCycle(), persistedResponse1.getCycle());
                Assertions.assertEquals(response.getWatering(), persistedResponse1.getWatering());
                Assertions.assertEquals(response.getSunlight(), persistedResponse1.getSunlight());
                Assertions.assertEquals(response.getImgUrl(), persistedResponse1.getImgUrl());
            } else if (response.getPlantId().equals(id2)) {
                Assertions.assertEquals(response.getPlantName(), persistedResponse2.getPlantName());
                Assertions.assertEquals(response.getScientificName(), persistedResponse2.getScientificName());
                Assertions.assertEquals(response.getCycle(), persistedResponse2.getCycle());
                Assertions.assertEquals(response.getWatering(), persistedResponse2.getWatering());
                Assertions.assertEquals(response.getSunlight(), persistedResponse2.getSunlight());
                Assertions.assertEquals(response.getImgUrl(), persistedResponse2.getImgUrl());
            }
        }

        plantService.delete(id1);
        plantService.delete(id2);
    }

    @Test
    public void plantController_getPlantCollection_emptyCollection() throws Exception {
        mvc.perform(get("/plant/collection/all").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }


    /** ------------------------------------------------------------------------
     *  plantController.getPlantByName()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantController_getPlantByName_successful() throws Exception {
        CreatePlantRequest request = new CreatePlantRequest();
        request.setPlantId(UUID.randomUUID().toString());
        request.setCycle("annual");
        request.setImgUrl("image");
        request.setSunlight("Medium Sun");
        request.setWatering("3 times a week");
        List<String> scientificNames = new ArrayList<>();
        scientificNames.add("Oak");
        scientificNames.add("Green Oak");
        request.setPlantName("Loving Daisy");
        request.setScientificName(scientificNames);

        PlantResponse plantResponse = plantService.createPlant(request);
        String mvcResponse = mvc.perform(get("/plant/list/{plantName}", plantResponse.getPlantName()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<PlantResponse> responseList = List.of(mapper.readValue(mvcResponse, PlantResponse[].class));
        PlantResponse response = responseList.get(0);
        Assertions.assertEquals(response.getPlantName(), plantResponse.getPlantName());
        Assertions.assertEquals(response.getScientificName(), plantResponse.getScientificName());
        Assertions.assertEquals(response.getCycle(), plantResponse.getCycle());
        Assertions.assertEquals(response.getWatering(), plantResponse.getWatering());
        Assertions.assertEquals(response.getSunlight(), plantResponse.getSunlight());
        Assertions.assertEquals(response.getImgUrl(), plantResponse.getImgUrl());

        plantService.delete(plantResponse.getPlantId());
    }

    @Test
    public void plantController_getPlantByName_plantNotFound() throws Exception {
        String notFoundName = "name missing";

        // WHEN
        mvc.perform(get("/plant/list/{plantName}", notFoundName).accept(MediaType.APPLICATION_JSON))
                // THEN
                .andExpect(status().isNotFound());
    }


    /** ------------------------------------------------------------------------
     *  plantController.deletePlant()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantController_deletePlant_successful() throws Exception {
        CreatePlantRequest request = new CreatePlantRequest();
        request.setPlantId(UUID.randomUUID().toString());
        request.setCycle("annual");
        request.setImgUrl("image");
        request.setSunlight("Medium Sun");
        request.setWatering("3 times a week");
        List<String> scientificNames = new ArrayList<>();
        scientificNames.add("Oak");
        scientificNames.add("Green Oak");
        request.setPlantName("Loving Daisy");
        request.setScientificName(scientificNames);

        PlantResponse plantResponse = plantService.createPlant(request);
        mvc.perform(delete("/plant/collection/{id}", plantResponse.getPlantId()).accept(MediaType.APPLICATION_JSON))
                // THEN
                .andExpect(status().isOk());
    }

    @Test
    public void plantController_deletePlantWithInvalidId_unsuccessful() throws Exception {
        String invalidId = "-1";

        mvc.perform(delete("/plant/collection/{id}", invalidId)
                    .accept(MediaType.APPLICATION_JSON))
        // THEN
                .andExpect(status().isBadRequest());
    }
}
