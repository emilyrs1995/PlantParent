package com.kenzie.appserver.api;

import com.kenzie.appserver.IntegrationTest;
import com.kenzie.capstone.service.client.PlantListLambdaServiceClient;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@IntegrationTest
public class GetPlantDetailsFromAPITest {
    private PlantListLambdaServiceClient client;

    @BeforeEach
    void setup() {
        client = new PlantListLambdaServiceClient();
    }

    @Test
    void getPlantDetails_withValidId_returnsDetails() {
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

        GetPlantDetailsResponse expectedResponse = new GetPlantDetailsResponse(id, name, scientificName, cycle, watering,
                sunlight, flowerColor, maintenance, careLevel, growthRate, indoor, hardinessZone, wateringBenchmark,
                medicinal, description, imgUrl);

        // WHEN
        GetPlantDetailsResponse actualResponse = client.getPlantDetails(id);

        System.out.println(actualResponse);

        // THEN
        Assertions.assertNotNull(actualResponse);
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

    /**
     * (BUG) - JSON mapping error (cannot parse object of type Array)
     * (FIX) - We use Objects in our model classes instead of Lists or the object classes that the Api is supposed to be
     * returning so that the Object mapper will read the value as an object, and then we cast them to a list or specific
     * object after the fact. This is because the external Api doesn't always send what we expect. So instead of a list,
     * they send a string, or instead of an object with its values, it sends an empty array. This solution works but
     * writing our own deserialization method would probably be a better long term fix.
     */
    @Test
    void getPlantDetails_withDifferentFields_returnsDetails () {
        // GIVEN
        String id = "45";
        String name = "Brandt's Dwarf Japanese Maple";
        List<String> scientificName = new ArrayList<>();
        scientificName.add("Acer palmatum 'Brandt's Dwarf'");
        String cycle = "Perennial";
        String watering = "Average";
        String sunlight = "full sun";
        String flowerColor = "The Brandt's Dwarf Japanese Maple plant does not have flowers.";
        String maintenance = "Unknown";
        String careLevel = "Moderate";
        String growthRate = "Low";
        String indoor = "false";
        String hardinessZone = "6 - 6";
        String wateringBenchmark = "Every 3-4 days";
        String medicinal = "false";
        String imgUrl = "https://perenual.com/storage/species_image/45_acer_palmatum_brandts_dwarf/regular/Acer_palmatum_BotGartenMuenster_Faecherahorn_6691.jpg";
        String description = "Brandt's Dwarf Japanese Maple is truly a unique and amazing species. Reaching a maximum size of " +
                "only two feet in height and three feet in width, this miniature maple tree features lacey, finely-cut leaves " +
                "in a deep burgundy color. In the spring, Brandt's Dwarf Japanese Maple bears small, star-shaped reddish-pink " +
                "flowers, which are followed in autumn by cloud-like clusters of tiny red fruits. Fascinating and resilient, " +
                "this plant is drought-tolerant and slow-growing, perfect for gardens and containers. Its vibrant foliage and " +
                "low maintenance make it a great addition to any landscape.";

        GetPlantDetailsResponse expectedResponse = new GetPlantDetailsResponse(id, name, scientificName, cycle, watering,
                sunlight, flowerColor, maintenance, careLevel, growthRate, indoor, hardinessZone, wateringBenchmark,
                medicinal, description, imgUrl);

        // WHEN
        GetPlantDetailsResponse actualResponse = client.getPlantDetails(id);

        System.out.println(actualResponse);

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
}
