package com.kenzie.appserver.service;

import com.kenzie.appserver.controller.PlantController;
import com.kenzie.appserver.controller.model.CreatePlantRequest;
import com.kenzie.appserver.controller.model.PlantDetailsResponse;
import com.kenzie.appserver.controller.model.PlantResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class PlantControllerTest {

    @Mock
    private PlantService plantService;

    @InjectMocks
    private PlantController plantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetPlantListByName_ValidName() {
        String plantName = "rose";
        List<PlantResponse> plantResponses = new ArrayList<>();
        plantResponses.add(new PlantResponse("1", "Rose", null, null, null, null, null));

        when(plantService.getPlantListByName(plantName)).thenReturn(plantResponses);

        ResponseEntity<List<PlantResponse>> responseEntity = plantController.getPlantListByName(plantName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(plantResponses, responseEntity.getBody());
    }

    @Test
    void testGetPlantListByName_InvalidName() {
        String invalidPlantName = "12345";
        assertThrows(ResponseStatusException.class, () -> plantController.getPlantListByName(invalidPlantName));
    }

    /**
     * (BUG) - A PlantName of only whitespace is being validated and shouldn't be
     * (FIX) - we strip the name of any leading or trailing whitespace in our validatePlantName() method and if the
     * name is then empty, we return false.
     */
    @Test
    void testGetPlantListByName_InvalidWhitespaceName() {
        String invalidPlantName = "   ";
        assertThrows(ResponseStatusException.class, () -> plantController.getPlantListByName(invalidPlantName));
    }

    @Test
    void testGetPlantListByName_EmptyResponse() {
        String validPlantName = "rose";
        when(plantService.getPlantListByName(validPlantName)).thenReturn(new ArrayList<>());

        ResponseEntity<List<PlantResponse>> responseEntity = plantController.getPlantListByName(validPlantName);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    void testGetPlantDetails_ValidId() {
        String validId = "1";
        PlantDetailsResponse plantDetailsResponse = new PlantDetailsResponse();
        plantDetailsResponse.setPlantId(validId);

        when(plantService.getPlantDetails(validId)).thenReturn(plantDetailsResponse);

        ResponseEntity<PlantDetailsResponse> responseEntity = plantController.getPlantDetails(validId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(plantDetailsResponse, responseEntity.getBody());
    }

    @Test
    void testGetPlantDetails_InvalidId() {
        String invalidId = "-1";
        assertThrows(ResponseStatusException.class, () -> plantController.getPlantDetails(invalidId));
    }

    @Test
    void testGetPlantDetails_EmptyResponse() {
        String validId = "1";
        when(plantService.getPlantDetails(validId)).thenReturn(null);

        ResponseEntity<PlantDetailsResponse> responseEntity = plantController.getPlantDetails(validId);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    void testAddNewPlant_ValidRequest() {
        CreatePlantRequest validRequest = new CreatePlantRequest("1", "Rose", null, null, null, null, null);
        PlantResponse createdResponse = new PlantResponse("1", "Rose", null, null, null, null, null);
        when(plantService.createPlant(validRequest)).thenReturn(createdResponse);

        ResponseEntity<PlantResponse> responseEntity = plantController.addNewPlant(validRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(createdResponse, responseEntity.getBody());
    }

    @Test
    void testAddNewPlant_InvalidPlantId() {
        CreatePlantRequest invalidPlantIdRequest = new CreatePlantRequest("3001", "Rose", null, null, null, null, null);
        assertThrows(ResponseStatusException.class, () -> plantController.addNewPlant(invalidPlantIdRequest));
    }

    /**
     * (BUG) - id that is not an integer throws NumberFormatException
     * (FIX) - added a try/catch block to the validateID() method. If the NumberFormatException is thrown then we return a false.
     */
    @Test
    void testAddNewPlant_InvalidStringPlantId() {
        String invalidPlantId = "Invalid";
        assertThrows(ResponseStatusException.class, () -> plantController.deletePlant(invalidPlantId));
    }

    @Test
    void testAddNewPlant_InvalidPlantName() {
        CreatePlantRequest invalidPlantIdRequest = new CreatePlantRequest("1", "#$:<&", null, null, null, null, null);
        assertThrows(ResponseStatusException.class, () -> plantController.addNewPlant(invalidPlantIdRequest));
    }

    /**
     * (BUG) - A PlantName of only whitespace is being validated and shouldn't be
     * (FIX) - we strip the name of any leading or trailing whitespace in our validatePlantName() method and if the
     * name is then empty, we return false.
     */
    @Test
    void testAddNewPlant_InvalidWhitespacePlantName() {
        CreatePlantRequest invalidPlantIdRequest = new CreatePlantRequest("1", "    ", null, null, null, null, null);
        assertThrows(ResponseStatusException.class, () -> plantController.addNewPlant(invalidPlantIdRequest));
    }

    @Test
    void testGetPlantCollection_NoPlantsFound() {
        when(plantService.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity<List<PlantResponse>> responseEntity = plantController.getPlantCollection();

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    void testGetPlantCollection_PlantsFound() {
        List<PlantResponse> plants = new ArrayList<>();
        plants.add(new PlantResponse("1", "Rose", null, null, null, null, null));
        plants.add(new PlantResponse("2", "Lily", null, null, null, null, null));

        when(plantService.findAll()).thenReturn(plants);

        ResponseEntity<List<PlantResponse>> responseEntity = plantController.getPlantCollection();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(plants, responseEntity.getBody());
    }

    @Test
    void testGetPlantByName_validName() {
        String validName = "orchid";
        List<PlantResponse> plants = new ArrayList<>();
        plants.add(new PlantResponse("1", validName, null, null, null, null, null));

        when(plantService.findByName(validName)).thenReturn(plants);

        ResponseEntity<List<PlantResponse>> responseEntity = plantController.getPlantByName(validName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(plants, responseEntity.getBody());
    }

    @Test
    void testGetPlantByName_InvalidName() {
        String invalidPlantName = "12345";
        assertThrows(ResponseStatusException.class, () -> plantController.getPlantByName(invalidPlantName));
    }

    /**
     * (BUG) - A PlantName of only whitespace is being validated and shouldn't be
     * (FIX) - we strip the name of any leading or trailing whitespace in our validatePlantName() method and if the
     * name is then empty, we return false.
     */
    @Test
    void testGetPlantByName_InvalidWhitespaceName() {
        String invalidPlantName = "    ";
        assertThrows(ResponseStatusException.class, () -> plantController.getPlantByName(invalidPlantName));
    }

    @Test
    void testGetPlantByName_EmptyResponse() {
        String validPlantName = "rose";
        when(plantService.findByName(validPlantName)).thenReturn(new ArrayList<>());

        ResponseEntity<List<PlantResponse>> responseEntity = plantController.getPlantByName(validPlantName);

        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    void testDeletePlant_InvalidPlantId() {
        String invalidPlantId = "-1";
        assertThrows(ResponseStatusException.class, () -> plantController.deletePlant(invalidPlantId));
    }

    /**
     * (BUG) - id that is not an integer throws NumberFormatException
     * (FIX) - added a try/catch block to the validateID() method. If the NumberFormatException is thrown then we return a false.
     */
    @Test
    void testDeletePlant_InvalidStringPlantId() {
        String invalidPlantId = "Invalid";
        assertThrows(ResponseStatusException.class, () -> plantController.deletePlant(invalidPlantId));
    }

    @Test
    void testDeletePlant_ValidPlantId() {
        String validPlantId = "1";
        ResponseEntity responseEntity = plantController.deletePlant(validPlantId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(plantService, times(1)).delete(validPlantId);
    }
}
