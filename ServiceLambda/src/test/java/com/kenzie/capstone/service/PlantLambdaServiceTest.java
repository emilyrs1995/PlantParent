package com.kenzie.capstone.service;

import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.exceptions.InvalidDataException;
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
        String imgUrl = "https://perenual.com/storage/species_image/61_acer_palmatum_hogyoku/thumbnail/2560px-Kyoto_Japan0431.jpg";
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
}
