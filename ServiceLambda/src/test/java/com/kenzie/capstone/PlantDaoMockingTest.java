package com.kenzie.capstone;

import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlantDaoMockingTest {

    private NonCachingPlantDao plantDao;

    @BeforeEach
    void setup() {
        this.plantDao = new NonCachingPlantDao();
    }


    /** ------------------------------------------------------------------------
     *  plantDao.getPlantList
     *  ------------------------------------------------------------------------ **/
    @Test
    void getPlantListSuccessful_withOneValidPlant_successful() {
        // GIVEN
        int id = 61;
        String name = "Hogyoku Japanese Maple";
        List<String> scientificName = new ArrayList<>();
        scientificName.add("Acer palmatum 'Hogyoku'");
        String cycle = "Perennial";
        String watering = "Average";
        String sunlight = "full sun";
        String imgUrl = "https://perenual.com/storage/species_image/61_acer_palmatum_hogyoku/small/2560px-Kyoto_Japan0431.jpg";

        GetPlantListResponse expectedResponse = new GetPlantListResponse(id, name, scientificName, cycle, watering, sunlight, imgUrl);

        // WHEN
        List<GetPlantListResponse> actualResponse = plantDao.mockingGettingOneResponseFromTheAPI();

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
    void getPlantList_withFiveValidPlants_successful() {
        // GIVEN
        int id1 = 644;
        String name1 = "bugleweed";
        List<String> scientificName1 = new ArrayList<>();
        scientificName1.add("Ajuga reptans 'Purple Torch'");
        String cycle1 = "Herbaceous Perennial";
        String watering1 = "Average";
        String sunlight1 = "full sun";
        String imgUrl1 = "https://perenual.com/storage/species_image/644_ajuga_reptans_purple_torch/small/Ajuga_reptans_Purple_Torch_0zz.jpg";
        GetPlantListResponse expectedResponse1 = new GetPlantListResponse(id1, name1, scientificName1, cycle1, watering1, sunlight1, imgUrl1);

        int id2 = 719;
        String name2 = "torch plant";
        List<String> scientificName2 = new ArrayList<>();
        scientificName2.add("Aloe aristata");
        String cycle2 = "Perennial";
        String watering2 = "Average";
        String sunlight2 = "full sun";
        String imgUrl2 = "https://perenual.com/storage/species_image/719_aloe_aristata/small/23962599232_fdc4070814_b.jpg";
        GetPlantListResponse expectedResponse2 = new GetPlantListResponse(id2, name2, scientificName2, cycle2, watering2, sunlight2, imgUrl2);

        int id3 = 1507;
        String name3 = "Scotch heather";
        List<String> scientificName3 = new ArrayList<>();
        scientificName3.add("Calluna vulgaris 'Spring Torch'");
        String cycle3 = "Perennial";
        String watering3 = "Average";
        String sunlight3 = "full sun";
        String imgUrl3 = "https://perenual.com/storage/species_image/1507_calluna_vulgaris_spring_torch/small/51961847247_65e0c7b6e7_b.jpg";
        GetPlantListResponse expectedResponse3 = new GetPlantListResponse(id3, name3, scientificName3, cycle3, watering3, sunlight3, imgUrl3);

        int id4 = 2689;
        String name4 = "coneflower";
        List<String> scientificName4 = new ArrayList<>();
        scientificName4.add("Echinacea 'Tiki Torch'");
        String cycle4 = "Herbaceous Perennial";
        String watering4 = "Minimum";
        String sunlight4 = "Full sun";
        String imgUrl4 = "https://perenual.com/storage/species_image/2689_echinacea_tiki_torch/small/4824363590_01907fc887_b.jpg";
        GetPlantListResponse expectedResponse4 = new GetPlantListResponse(id4, name4, scientificName4, cycle4, watering4, sunlight4, imgUrl4);

        int id5 = 2823;
        String name5 = "torch ginger";
        List<String> scientificName5 = new ArrayList<>();
        scientificName5.add("Etlingera elatior");
        String cycle5 = "Herbaceous Perennial";
        String watering5 = "Average";
        String sunlight5 = "full sun";
        String imgUrl5 = "https://perenual.com/storage/species_image/2823_etlingera_elatior/small/27955726500_9b9213a47a_b.jpg";
        GetPlantListResponse expectedResponse5 = new GetPlantListResponse(id5, name5, scientificName5, cycle5, watering5, sunlight5, imgUrl5);

        // WHEN
        List<GetPlantListResponse> actualResponses = plantDao.mockingGettingFiveResponsesFromTheAPI();

        // THEN
        Assertions.assertNotNull(actualResponses);
        Assertions.assertEquals(5, actualResponses.size());

        for (GetPlantListResponse printResponses : actualResponses) {
            System.out.println(printResponses);
        }

        for (GetPlantListResponse response : actualResponses) {
            if (response.getPlantId() == expectedResponse1.getPlantId()) {
                Assertions.assertEquals(expectedResponse1.getPlantName(), response.getPlantName());
                Assertions.assertEquals(expectedResponse1.getScientificName(), response.getScientificName());
                Assertions.assertEquals(expectedResponse1.getCycle(), response.getCycle());
                Assertions.assertEquals(expectedResponse1.getWatering(), response.getWatering());
                Assertions.assertEquals(expectedResponse1.getSunlight(), response.getSunlight());
                Assertions.assertEquals(expectedResponse1.getIMGUrl(), response.getIMGUrl());
            } else if (response.getPlantId() == expectedResponse2.getPlantId()) {
                Assertions.assertEquals(expectedResponse2.getPlantName(), response.getPlantName());
                Assertions.assertEquals(expectedResponse2.getScientificName(), response.getScientificName());
                Assertions.assertEquals(expectedResponse2.getCycle(), response.getCycle());
                Assertions.assertEquals(expectedResponse2.getWatering(), response.getWatering());
                Assertions.assertEquals(expectedResponse2.getSunlight(), response.getSunlight());
                Assertions.assertEquals(expectedResponse2.getIMGUrl(), response.getIMGUrl());
            } else if (response.getPlantId() == expectedResponse3.getPlantId()) {
                Assertions.assertEquals(expectedResponse3.getPlantName(), response.getPlantName());
                Assertions.assertEquals(expectedResponse3.getScientificName(), response.getScientificName());
                Assertions.assertEquals(expectedResponse3.getCycle(), response.getCycle());
                Assertions.assertEquals(expectedResponse3.getWatering(), response.getWatering());
                Assertions.assertEquals(expectedResponse3.getSunlight(), response.getSunlight());
                Assertions.assertEquals(expectedResponse3.getIMGUrl(), response.getIMGUrl());
            } else if (response.getPlantId() == expectedResponse4.getPlantId()) {
                Assertions.assertEquals(expectedResponse4.getPlantName(), response.getPlantName());
                Assertions.assertEquals(expectedResponse4.getScientificName(), response.getScientificName());
                Assertions.assertEquals(expectedResponse4.getCycle(), response.getCycle());
                Assertions.assertEquals(expectedResponse4.getWatering(), response.getWatering());
                Assertions.assertEquals(expectedResponse4.getSunlight(), response.getSunlight());
                Assertions.assertEquals(expectedResponse4.getIMGUrl(), response.getIMGUrl());
            } else if (response.getPlantId() == expectedResponse5.getPlantId()) {
                Assertions.assertEquals(expectedResponse5.getPlantName(), response.getPlantName());
                Assertions.assertEquals(expectedResponse5.getScientificName(), response.getScientificName());
                Assertions.assertEquals(expectedResponse5.getCycle(), response.getCycle());
                Assertions.assertEquals(expectedResponse5.getWatering(), response.getWatering());
                Assertions.assertEquals(expectedResponse5.getSunlight(), response.getSunlight());
                Assertions.assertEquals(expectedResponse5.getIMGUrl(), response.getIMGUrl());
            }
        }
    }

    @Test
    void getPlantList_withTwoValidPlants_andOneInvalid_onlyReturnsValid() {
        // GIVEN
        int id1 = 1191;
        String name1 = "Hong Kong orchid tree";
        List<String> scientificName1 = new ArrayList<>();
        scientificName1.add("Bauhinia blakeana");
        String cycle1 = "Perennial";
        String watering1 = "Average";
        String sunlight1 = "Full sun";
        String imgUrl1 = "https://perenual.com/storage/species_image/1191_bauhinia_blakeana/small/52661560703_469c6c5af9_b.jpg";
        GetPlantListResponse expectedResponse1 = new GetPlantListResponse(id1, name1, scientificName1, cycle1, watering1, sunlight1, imgUrl1);

        int id2 = 1299;
        String name2 = "Chinese ground orchid";
        List<String> scientificName2 = new ArrayList<>();
        scientificName2.add("Bletilla striata");
        String cycle2 = "Perennial";
        String watering2 = "Average";
        String sunlight2 = "Part shade";
        String imgUrl2 = "https://perenual.com/storage/species_image/1299_bletilla_striata/small/46779845065_57a4c9f61d_b.jpg";
        GetPlantListResponse expectedResponse2 = new GetPlantListResponse(id2, name2, scientificName2, cycle2, watering2, sunlight2, imgUrl2);

        // WHEN
        List<GetPlantListResponse> actualResponses = plantDao.mockingGettingTwoValidResponsesAndOneInvalidResponseFromTheAPI();

        // THEN
        Assertions.assertNotNull(actualResponses);
        Assertions.assertEquals(2, actualResponses.size());

        for (GetPlantListResponse printResponses : actualResponses) {
            System.out.println(printResponses);
        }

        for (GetPlantListResponse response : actualResponses) {
            if (response.getPlantId() == expectedResponse1.getPlantId()) {
                Assertions.assertEquals(expectedResponse1.getPlantName(), response.getPlantName());
                Assertions.assertEquals(expectedResponse1.getScientificName(), response.getScientificName());
                Assertions.assertEquals(expectedResponse1.getCycle(), response.getCycle());
                Assertions.assertEquals(expectedResponse1.getWatering(), response.getWatering());
                Assertions.assertEquals(expectedResponse1.getSunlight(), response.getSunlight());
                Assertions.assertEquals(expectedResponse1.getIMGUrl(), response.getIMGUrl());
            } else if (response.getPlantId() == expectedResponse2.getPlantId()) {
                Assertions.assertEquals(expectedResponse2.getPlantName(), response.getPlantName());
                Assertions.assertEquals(expectedResponse2.getScientificName(), response.getScientificName());
                Assertions.assertEquals(expectedResponse2.getCycle(), response.getCycle());
                Assertions.assertEquals(expectedResponse2.getWatering(), response.getWatering());
                Assertions.assertEquals(expectedResponse2.getSunlight(), response.getSunlight());
                Assertions.assertEquals(expectedResponse2.getIMGUrl(), response.getIMGUrl());
            }
        }
    }


    /** ------------------------------------------------------------------------
     *  plantDao.getPlantDetails
     *  ------------------------------------------------------------------------ **/
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

        GetPlantDetailsResponse expectedResponse = new GetPlantDetailsResponse(id, name, scientificName, cycle, watering, sunlight, flowerColor, maintenance, careLevel,
                growthRate, indoor, hardinessZone, wateringBenchmark, medicinal, description, imgUrl);

        // WHEN
        GetPlantDetailsResponse actualResponse = plantDao.mockingGettingPlantDetailsForValidId();

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
}
