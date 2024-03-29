package com.kenzie.capstone.service;

import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.exceptions.InvalidDataException;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class PlantLambdaServiceTest {

    @InjectMocks
    private PlantLambdaService plantLambdaService;

    @Mock
    private NonCachingPlantDao nonCachingPlantDao;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /** ------------------------------------------------------------------------
     *  PlantListLambdaService.getPlantList
     *  ------------------------------------------------------------------------ **/
    @Test
    void getPlantList_successful() {
        // GIVEN
        String plantName = "hogyoku";

        int id = 61;
        String name = "Hogyoku Japanese Maple";
        List<String> scientificName = new ArrayList<>();
        scientificName.add("Acer palmatum 'Hogyoku'");
        String cycle = "Perennial";
        String watering = "Average";
        String sunlight = "full sun";
        String imgUrl = "https://perenual.com/storage/species_image/61_acer_palmatum_hogyoku/small/2560px-Kyoto_Japan0431.jpg";
        GetPlantListResponse expectedResponse = new GetPlantListResponse(id, name, scientificName, cycle, watering, sunlight, imgUrl);

        List<GetPlantListResponse> expectedResponses = new ArrayList<>();
        expectedResponses.add(expectedResponse);

        when(nonCachingPlantDao.getPlantList(plantName)).thenReturn(expectedResponses);

        // WHEN
        List<GetPlantListResponse> actualResponse = plantLambdaService.getPlantList(plantName);

        // THEN
        Assertions.assertEquals(1, actualResponse.size());

        GetPlantListResponse returnedResponse = actualResponse.get(0);
        System.out.println(returnedResponse);

        Assertions.assertEquals(expectedResponse.getPlantId(), returnedResponse.getPlantId());
        Assertions.assertEquals(expectedResponse.getPlantName(), returnedResponse.getPlantName());
        Assertions.assertEquals(expectedResponse.getScientificName(), returnedResponse.getScientificName());
        Assertions.assertEquals(expectedResponse.getCycle(), returnedResponse.getCycle());
        Assertions.assertEquals(expectedResponse.getWatering(), returnedResponse.getWatering());
        Assertions.assertEquals(expectedResponse.getSunlight(), returnedResponse.getSunlight());
        Assertions.assertEquals(expectedResponse.getIMGUrl(), returnedResponse.getIMGUrl());
    }

    @Test
    void getPlantList_withNullName_throwsInvalidDataException() {
        // GIVEN
        String plantName = null;

        // WHEN
        // THEN
        Assertions.assertThrows(InvalidDataException.class, () -> plantLambdaService.getPlantList(plantName));
    }

    @Test
    void getPlantList_withEmptyName_throwsInvalidDataException() {
        // GIVEN
        String plantName = "";

        // WHEN
        // THEN
        Assertions.assertThrows(InvalidDataException.class, () -> plantLambdaService.getPlantList(plantName));
    }

    /** ------------------------------------------------------------------------
     *  PlantListLambdaService.getPlantDetails
     *  ------------------------------------------------------------------------ **/
    @Test
    void getPlantDetails_successful() {
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

        GetPlantDetailsResponse expectedResponse = new GetPlantDetailsResponse(id, name, scientificName, cycle, watering, sunlight, flowerColor, maintenance, careLevel,
                growthRate, indoor, hardinessZone, wateringBenchmark, medicinal, description, imgUrl);

        when(nonCachingPlantDao.getPlantDetails(id)).thenReturn(expectedResponse);

        // WHEN
        GetPlantDetailsResponse actualResponse = plantLambdaService.getPlantDetails(id);

        // THEN
        Assertions.assertEquals(expectedResponse.getPlantId(), actualResponse.getPlantId());
        Assertions.assertEquals(expectedResponse.getPlantName(), actualResponse.getPlantName());
        Assertions.assertEquals(expectedResponse.getScientificName(), actualResponse.getScientificName());
        Assertions.assertEquals(expectedResponse.getCycle(), actualResponse.getCycle());
        Assertions.assertEquals(expectedResponse.getWatering(), actualResponse.getWatering());
        Assertions.assertEquals(expectedResponse.getSunlight(), actualResponse.getSunlight());
        Assertions.assertEquals(expectedResponse.getFlowerColor(), actualResponse.getFlowerColor());
        Assertions.assertEquals(expectedResponse.getMaintenance(), actualResponse.getMaintenance());
        Assertions.assertEquals(expectedResponse.getCareLevel(), actualResponse.getCareLevel());
        Assertions.assertEquals(expectedResponse.getGrowthRate(), actualResponse.getGrowthRate());
        Assertions.assertEquals(expectedResponse.getIndoor(), actualResponse.getIndoor());
        Assertions.assertEquals(expectedResponse.getHardinessZone(), actualResponse.getHardinessZone());
        Assertions.assertEquals(expectedResponse.getWateringBenchmark(), actualResponse.getWateringBenchmark());
        Assertions.assertEquals(expectedResponse.getMedicinal(), actualResponse.getMedicinal());
        Assertions.assertEquals(expectedResponse.getIMGUrl(), actualResponse.getIMGUrl());
        Assertions.assertEquals(expectedResponse.getDescription(), actualResponse.getDescription());
    }

    @Test
    void getPlantDetails_withNullId_throwsInvalidDataException() {
        // GIVEN
        String id = null;

        // WHEN
        // THEN
        Assertions.assertThrows(InvalidDataException.class, () -> plantLambdaService.getPlantDetails(id));
    }

    @Test
    void getPlantDetails_withEmptyId_throwsInvalidDataException() {
        // GIVEN
        String id = "";

        // WHEN
        // THEN
        Assertions.assertThrows(InvalidDataException.class, () -> plantLambdaService.getPlantDetails(id));
    }
}
