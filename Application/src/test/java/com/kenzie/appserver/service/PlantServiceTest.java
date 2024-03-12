package com.kenzie.appserver.service;

import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantResponse;
import com.kenzie.appserver.repositories.PlantRepository;
import com.kenzie.appserver.repositories.model.PlantRecord;
import com.kenzie.capstone.service.client.PlantListLambdaServiceClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class PlantServiceTest {

    @InjectMocks
    private PlantService plantService;
    @Mock
    private PlantRepository plantRepository;
    @Mock
    private PlantListLambdaServiceClient plantListLambdaServiceClient;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /** ------------------------------------------------------------------------
     *  plantService.getPlantListByName
     *  ------------------------------------------------------------------------ **/
    @Test
    void getPlantListByName() {

    }

    /** ------------------------------------------------------------------------
     *  plantService.createPlant
     *  ------------------------------------------------------------------------ **/
    @Test
    void createPlant_validFields_returnsResponse() {
        // GIVEN
        List<String> scientificNames = new ArrayList<>();
        scientificNames.add("fancy names");
        scientificNames.add("more fancy names");

        CreatePlantRequest request = new CreatePlantRequest();
        request.setPlantId("123");
        request.setPlantName("aloe");
        request.setScientificName(scientificNames);
        request.setCycle("perennial");
        request.setWatering("average");
        request.setSunlight("full sun");
        request.setImgUrl("imageURL");

        PlantRecord record = new PlantRecord();
        record.setPlantId(request.getPlantId());
        record.setPlantName(request.getPlantName());
        record.setScientificName(scientificNames);
        record.setCycle(request.getCycle());
        record.setWatering(request.getWatering());
        record.setSunlight(request.getSunlight());
        record.setImgUrl(request.getImgUrl());

        // WHEN
        PlantResponse response = plantService.createPlant(request);

        // THEN
        verify(plantRepository).save(record);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(request.getPlantId(), response.getPlantId());
        Assertions.assertEquals(request.getPlantName(), response.getPlantName());
        Assertions.assertEquals(request.getScientificName(), response.getScientificName());
        Assertions.assertEquals(request.getCycle(), response.getCycle());
        Assertions.assertEquals(request.getWatering(), response.getWatering());
        Assertions.assertEquals(request.getSunlight(), response.getSunlight());
        Assertions.assertEquals(request.getImgUrl(), response.getImgUrl());
    }

    /** ------------------------------------------------------------------------
     *  plantService.getPlantCollection
     *  ------------------------------------------------------------------------ **/
    @Test
    void getPlantCollection_withValidRecords_returnsResponseList() {
        // GIVEN
        List<String> scientificNames = new ArrayList<>();
        scientificNames.add("fancy names");
        scientificNames.add("more fancy names");

        PlantRecord record1 = new PlantRecord();
        record1.setPlantId("123");
        record1.setPlantName("aloe");
        record1.setScientificName(scientificNames);
        record1.setCycle("perennial");
        record1.setWatering("average");
        record1.setSunlight("full sun");
        record1.setImgUrl("imageURL");

        PlantRecord record2 = new PlantRecord();
        record2.setPlantId("456");
        record2.setPlantName("spider plant");
        record2.setScientificName(scientificNames);
        record2.setCycle("annual");
        record2.setWatering("average");
        record2.setSunlight("part shade");
        record2.setImgUrl("imageURL");

        List<PlantRecord> records = new ArrayList<>();
        records.add(record1);
        records.add(record2);

        when(plantRepository.findAll()).thenReturn(records);

        // WHEN
        List<PlantResponse> responseList = plantService.findAll();

        // THEN
        Assertions.assertNotNull(responseList);
        Assertions.assertEquals(2, responseList.size());

        for (PlantResponse response : responseList) {
            if(response.getPlantId().equals(record1.getPlantId())) {
                Assertions.assertEquals(record1.getPlantName(), response.getPlantName());
                Assertions.assertEquals(record1.getScientificName(), response.getScientificName());
                Assertions.assertEquals(record1.getCycle(), response.getCycle());
                Assertions.assertEquals(record1.getWatering(), response.getWatering());
                Assertions.assertEquals(record1.getSunlight(), response.getSunlight());
                Assertions.assertEquals(record1.getImgUrl(), response.getImgUrl());
            } else if (response.getPlantId().equals(record2.getPlantId())) {
                Assertions.assertEquals(record2.getPlantName(), response.getPlantName());
                Assertions.assertEquals(record2.getScientificName(), response.getScientificName());
                Assertions.assertEquals(record2.getCycle(), response.getCycle());
                Assertions.assertEquals(record2.getWatering(), response.getWatering());
                Assertions.assertEquals(record2.getSunlight(), response.getSunlight());
                Assertions.assertEquals(record2.getImgUrl(), response.getImgUrl());
            } else {
                Assertions.assertTrue(false, "Response returned that was not in the records");
            }
        }
    }

    /** ------------------------------------------------------------------------
     *  plantService.getPlantByName
     *  ------------------------------------------------------------------------ **/
    @Test
    void getPlantByName_withThreeValidRecords_ReturnsTwoWithCorrectName() {
        // GIVEN
        String name = "aloe";

        List<String> scientificNames = new ArrayList<>();
        scientificNames.add("fancy names");
        scientificNames.add("more fancy names");

        PlantRecord record1 = new PlantRecord();
        record1.setPlantId("123");
        record1.setPlantName("aloe");
        record1.setScientificName(scientificNames);
        record1.setCycle("perennial");
        record1.setWatering("average");
        record1.setSunlight("full sun");
        record1.setImgUrl("imageURL");

        PlantRecord record2 = new PlantRecord();
        record2.setPlantId("456");
        record2.setPlantName("spider plant");
        record2.setScientificName(scientificNames);
        record2.setCycle("annual");
        record2.setWatering("average");
        record2.setSunlight("part shade");
        record2.setImgUrl("imageURL");

        PlantRecord record3 = new PlantRecord();
        record3.setPlantId("789");
        record3.setPlantName("aloe vera");
        record3.setScientificName(scientificNames);
        record3.setCycle("perennial");
        record3.setWatering("average");
        record3.setSunlight("full sun");
        record3.setImgUrl("imageURL");

        List<PlantRecord> records = new ArrayList<>();
        records.add(record1);
        records.add(record2);
        records.add(record3);

        when(plantRepository.findAll()).thenReturn(records);

        // WHEN
        List<PlantResponse> plantResponses = plantService.findByName(name);

        // THEN
        Assertions.assertNotNull(plantResponses);
        Assertions.assertEquals(2, plantResponses.size());

        for (PlantResponse response : plantResponses) {
            Assertions.assertTrue(response.getPlantName().contains(name));
            if (response.getPlantId().equals(record1.getPlantId())) {
                Assertions.assertEquals(record1.getPlantName(), response.getPlantName());
                Assertions.assertEquals(record1.getScientificName(), response.getScientificName());
                Assertions.assertEquals(record1.getCycle(), response.getCycle());
                Assertions.assertEquals(record1.getWatering(), response.getWatering());
                Assertions.assertEquals(record1.getSunlight(), response.getSunlight());
                Assertions.assertEquals(record1.getImgUrl(), response.getImgUrl());
            } else if (response.getPlantId().equals(record3.getPlantId())) {
                Assertions.assertEquals(record3.getPlantName(), response.getPlantName());
                Assertions.assertEquals(record3.getScientificName(), response.getScientificName());
                Assertions.assertEquals(record3.getCycle(), response.getCycle());
                Assertions.assertEquals(record3.getWatering(), response.getWatering());
                Assertions.assertEquals(record3.getSunlight(), response.getSunlight());
                Assertions.assertEquals(record3.getImgUrl(), response.getImgUrl());
            }
        }
    }

    /** ------------------------------------------------------------------------
     *  plantService.deletePlant
     *  ------------------------------------------------------------------------ **/
    @Test
    void deletePlant_withValidId_deletesId() {
        // GIVEN
        String id = "123";

        // WHEN
        plantService.delete(id);

        // THEN
        verify(plantRepository).deleteById(id);
    }
}
