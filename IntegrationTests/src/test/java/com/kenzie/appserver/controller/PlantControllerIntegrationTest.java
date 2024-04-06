package com.kenzie.appserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.kenzie.appserver.IntegrationTest;
import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantDetailsResponse;
import com.kenzie.appserver.controller.model.PlantResponse;
import com.kenzie.appserver.service.PlantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        // GIVEN
        String plantName = "torch";

        // WHEN
        ResultActions actions = mvc.perform(get("/plant/list/{plantName}", plantName)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        String responseBody = actions.andReturn().getResponse().getContentAsString();
        List<PlantResponse> responseList = List.of(mapper.readValue(responseBody, PlantResponse[].class));

        // THEN
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
        // GIVEN
        CreatePlantRequest request = new CreatePlantRequest();
        request.setCycle("annual");
        request.setImgUrl("image");
        request.setSunlight("Medium Sun");
        request.setWatering("3 times a week");
        List<String> scientificNames = Arrays.asList("Oak", "Green Oak");
        request.setScientificName(scientificNames);
        request.setPlantName("Loving Daisy");
        request.setPlantId("3");

        // WHEN
        ResultActions actions = mvc.perform(post("/plant/collection")
                        .content(mapper.writeValueAsString(request))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        String responseBody = actions.andReturn().getResponse().getContentAsString();
        PlantResponse response = mapper.readValue(responseBody, PlantResponse.class);

        // THEN
        assertThat(response.getPlantId()).isEqualTo(request.getPlantId());
        assertThat(response.getPlantName()).isEqualTo(request. getPlantName());
        assertThat(response.getCycle()).isEqualTo(request.getCycle());
        assertThat(response.getWatering()).isEqualTo(request.getWatering());
        assertThat(response.getSunlight()).isEqualTo(request.getSunlight());
        assertThat(response.getScientificName()).isEqualTo(request.getScientificName());
        assertThat(response.getImgUrl()).isEqualTo(request.getImgUrl());
    }

    @Test
    public void plantController_addNewPlantWithNullFields_unsuccessful() throws Exception {
        // GIVEN
        CreatePlantRequest request = new CreatePlantRequest();

        // WHEN
        mvc.perform(post("/plant/collection")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(request)))
        // THEN
                .andExpect(status().isBadRequest());


    }


    /** ------------------------------------------------------------------------
     *  plantController.getPlantCollection()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantController_getPlantCollection_successful() throws Exception {
        // GIVEN
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

        // WHEN
        String mvcResponse = mvc.perform(get("/plant/collection/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        List<PlantResponse> responseList = List.of(mapper.readValue(mvcResponse, PlantResponse[].class));

        // THEN
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
        // GIVEN/WHEN
        mvc.perform(get("/plant/collection/all")
                        .accept(MediaType.APPLICATION_JSON))
        // THEN
                .andExpect(status().isNoContent());
    }


    /** ------------------------------------------------------------------------
     *  plantController.getPlantByName()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantController_getPlantByName_successful() throws Exception {
        // GIVEN
        CreatePlantRequest request = new CreatePlantRequest();
        request.setPlantId("3");
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

        // WHEN
        ResultActions actions = mvc.perform(get("/plant/collection/{plantName}", plantResponse.getPlantName())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        String responseBody = actions.andReturn().getResponse().getContentAsString();
        List<PlantResponse> responseList = List.of(mapper.readValue(responseBody, PlantResponse[].class));
        PlantResponse response = responseList.get(0);

        // THEN
        Assertions.assertEquals(response.getPlantId(), plantResponse.getPlantId());
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
        // GIVEN
        String notFoundName = "name missing";

        // WHEN
        mvc.perform(get("/plant/collection/{plantName}", notFoundName)
                        .accept(MediaType.APPLICATION_JSON))
        // THEN
                .andExpect(status().isNoContent());
    }


    /** ------------------------------------------------------------------------
     *  plantController.deletePlant()
     *  ------------------------------------------------------------------------ **/
    @Test
    public void plantController_deletePlant_successful() throws Exception {
        // GIVEN
        CreatePlantRequest request = new CreatePlantRequest();
        request.setPlantId("3");
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

        // WHEN
        mvc.perform(delete("/plant/collection/delete/{id}", plantResponse.getPlantId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // THEN
        mvc.perform(get("/plant/collection/{plantName}", plantResponse.getPlantName())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void plantController_deletePlantWithInvalidId_unsuccessful() throws Exception {
        // GIVEN
        String invalidId = "-1";

        // WHEN
        mvc.perform(delete("/plant/collection/delete/{id}", invalidId)
                    .accept(MediaType.APPLICATION_JSON))
        // THEN
                .andExpect(status().isBadRequest());
    }
}
