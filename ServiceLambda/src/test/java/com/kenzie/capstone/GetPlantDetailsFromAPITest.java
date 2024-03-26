package com.kenzie.capstone;

import com.kenzie.capstone.service.PlantLambdaService;
import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GetPlantDetailsFromAPITest {

    private PlantLambdaService plantLambdaService;
    private NonCachingPlantDao plantDao;

    @BeforeEach
    void setup() {
        this.plantDao = new NonCachingPlantDao();
        this.plantLambdaService = new PlantLambdaService(plantDao);
    }

    @Test
    void getPlantDetails_withValidId_returnsDetails() {
        // GIVEN
        String id = "61";
        String name = "Hogyoku Japanese Maple";
        String flowerColor = "Reddish-purple";
        String maintenance = "Low";
        String careLevel = "Unknown";
        String growthRate = "Low";
        String indoor = "false";
        String hardinessZone = "7 - 7";
        String wateringBenchmark = "Every 3-4 days";
        String medicinal = "false";
        String description = "Hogyoku Japanese Maple (Acer palmatum 'Hogyoku') is an amazing plant species noted for its striking beauty. " +
                "Its delicate foliage emerges with a golden hue and develops into a vibrant, deep scarlet during the cooler months. " +
                "Bright red flowers bloom in spring and bring in stunning hues all season long. The foliage turns to yellow, orange, " +
                "and pink in the fall. Outstanding bark color is a nice addition to the landscape - from cinnamon-red to orange and yellow. " +
                "The beauty of tiger-striped bark truly stands out in the winter. Hogyoku is easy to grow and low-maintenance. " +
                "It also does extremely well in containers and makes a stunning accent for any garden.";

        GetPlantDetailsResponse expectedResponse = new GetPlantDetailsResponse(id, name, flowerColor, maintenance, careLevel,
                growthRate, indoor, hardinessZone, wateringBenchmark, medicinal, description);

        // WHEN
        GetPlantDetailsResponse actualResponse = plantLambdaService.getPlantDetails(id);

        System.out.println(actualResponse);

        // THEN
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedResponse.getPlantId(), actualResponse.getPlantId());
        Assertions.assertEquals(expectedResponse.getPlantName(), actualResponse.getPlantName());
        Assertions.assertEquals(expectedResponse.getFlowerColor(), actualResponse.getFlowerColor());
        Assertions.assertEquals(expectedResponse.getMaintenance(), actualResponse.getMaintenance());
        Assertions.assertEquals(expectedResponse.getCareLevel(), actualResponse.getCareLevel());
        Assertions.assertEquals(expectedResponse.getGrowthRate(), actualResponse.getGrowthRate());
        Assertions.assertEquals(expectedResponse.getIndoor(), actualResponse.getIndoor());
        Assertions.assertEquals(expectedResponse.getHardinessZone(), actualResponse.getHardinessZone());
        Assertions.assertEquals(expectedResponse.getWateringBenchmark(), actualResponse.getWateringBenchmark());
        Assertions.assertEquals(expectedResponse.getMedicinal(), actualResponse.getMedicinal());
        Assertions.assertEquals(expectedResponse.getDescription(), actualResponse.getDescription());
    }

    @Test
    void getPlantDetails_withDifferentFields_returnsDetails () {
        String id = "45";
        String name = "Brandt's Dwarf Japanese Maple";
        String flowerColor = "The Brandt's Dwarf Japanese Maple plant does not have flowers.";
        String maintenance = "Unknown";
        String careLevel = "Moderate";
        String growthRate = "Low";
        String indoor = "false";
        String hardinessZone = "6 - 6";
        String wateringBenchmark = "Every 3-4 days";
        String medicinal = "false";
        String description = "Brandt's Dwarf Japanese Maple is truly a unique and amazing species. Reaching a maximum size of " +
                "only two feet in height and three feet in width, this miniature maple tree features lacey, finely-cut leaves " +
                "in a deep burgundy color. In the spring, Brandt's Dwarf Japanese Maple bears small, star-shaped reddish-pink " +
                "flowers, which are followed in autumn by cloud-like clusters of tiny red fruits. Fascinating and resilient, " +
                "this plant is drought-tolerant and slow-growing, perfect for gardens and containers. Its vibrant foliage and " +
                "low maintenance make it a great addition to any landscape.";

        GetPlantDetailsResponse expectedResponse = new GetPlantDetailsResponse(id, name, flowerColor, maintenance, careLevel,
                growthRate, indoor, hardinessZone, wateringBenchmark, medicinal, description);

        // WHEN
        GetPlantDetailsResponse actualResponse = plantLambdaService.getPlantDetails(id);

        System.out.println(actualResponse);

        // THEN
        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedResponse.getPlantId(), actualResponse.getPlantId());
        Assertions.assertEquals(expectedResponse.getPlantName(), actualResponse.getPlantName());
        Assertions.assertEquals(expectedResponse.getFlowerColor(), actualResponse.getFlowerColor());
        Assertions.assertEquals(expectedResponse.getMaintenance(), actualResponse.getMaintenance());
        Assertions.assertEquals(expectedResponse.getCareLevel(), actualResponse.getCareLevel());
        Assertions.assertEquals(expectedResponse.getGrowthRate(), actualResponse.getGrowthRate());
        Assertions.assertEquals(expectedResponse.getIndoor(), actualResponse.getIndoor());
        Assertions.assertEquals(expectedResponse.getHardinessZone(), actualResponse.getHardinessZone());
        Assertions.assertEquals(expectedResponse.getWateringBenchmark(), actualResponse.getWateringBenchmark());
        Assertions.assertEquals(expectedResponse.getMedicinal(), actualResponse.getMedicinal());
        Assertions.assertEquals(expectedResponse.getDescription(), actualResponse.getDescription());
    }

}
