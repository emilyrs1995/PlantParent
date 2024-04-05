package com.kenzie.capstone.cache;

import com.kenzie.capstone.service.caching.CacheClient;
import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

public class CacheClientTest {

    private NonCachingPlantDao plantDao;

    @BeforeEach
    void setup() {
        this.plantDao = new NonCachingPlantDao();
    }

    @Test
    public void getPlantList_cachedSuccessfully() {
        // GIVEN
        CacheClient<String, String> cacheClient = new CacheClient<>(3);

        String plantJson = "[{\"plantId\":\"24\",\"plantName\":\"Mocha Rose Big Leaf Maple\",\"scientificName\":[\"Acer " +
                "macrophyllum 'Mocha Rose'\"],\"cycle\":\"Perennial\",\"watering\":\"Average\",\"sunlight\":\"full sun\"," +
                "\"imgUrl\":\"https://perenual.com/storage/species_image/24_acer_macrophyllum_mocha_rose/small/4715169892_220a9d39f6_b.jpg\"}," +
                "{\"plantId\":\"334\",\"plantName\":\"Rose Marie Magnolia\",\"scientificName\":[\"Magnolia 'Rose Marie'\"]," +
                "\"cycle\":\"Perennial\",\"watering\":\"Minimum\",\"sunlight\":\"full sun\",\"imgUrl\":" +
                "\"https://perenual.com/storage/species_image/334_magnolia_rose_marie/small/Magnolia_C397_soulangeana_BW_1.jpg\"}," +
                "{\"plantId\":\"355\",\"plantName\":\"Candied Apple Flowering Crab\",\"scientificName\":[\"Malus 'Candied Apple'\"]," +
                "\"cycle\":\"Perennial\",\"watering\":\"Average\",\"sunlight\":\"full sun\",\"imgUrl\":" +
                "\"https://perenual.com/storage/species_image/355_malus_candied_apple/small/663px-Apples_on_tree_2021_G1.jpg\"}," +
                "{\"plantId\":\"359\",\"plantName\":\"Dolgo Apple\",\"scientificName\":[\"Malus 'Dolgo'\"],\"cycle\":\"Perennial\"," +
                "\"watering\":\"Average\",\"sunlight\":\"full sun\",\"imgUrl\":" +
                "\"https://perenual.com/storage/species_image/359_malus_dolgo/small/apple-zieraepfel-wild-apple-tree-branch.jpg\"}," +
                "{\"plantId\":\"360\",\"plantName\":\"Donald Wyman Flowering Crab\",\"scientificName\":[\"Malus 'Donald Wyman'\"],\"cycle\":" +
                "\"Perennial\",\"watering\":\"Average\",\"sunlight\":\"full sun\",\"imgUrl\":" +
                "\"https://perenual.com/storage/species_image/360_malus_donald_wyman/small/frembellishment_apple_small_694055-image-kybdt6db.jpg\"}]";

        List<GetPlantListResponse> apiResponse = plantDao.getPlantList("rose");
        Assertions.assertEquals(5, apiResponse.size());

        // WHEN
        cacheClient.put("PlantList::rose", plantJson);
        String cacheResponse = cacheClient.get("PlantList::rose");

        // THEN
        Assertions.assertEquals(plantJson, cacheResponse);
    }

    @Test
    public void getPlantDetails_cachedSuccessfully() {
        // GIVEN
        CacheClient<String, String> cacheClient = new CacheClient<>(3);

        String plantJson = "{\"plantId\":\"34\",\"plantName\":\"Ribbon-leaf Japanese Maple*\",\"scientificName\":[\"Acer palmatum " +
                "'Atrolineare'\"],\"cycle\":\"Perennial\",\"watering\":\"Minimum\",\"sunlight\":\"full sun\",\"flowerColor\":" +
                "\"The Ribbon-leaf Japanese Maple* plant does not have flowers.\",\"maintenance\":\"Unknown\",\"careLevel\":" +
                "\"High\",\"growthRate\":\"Low\",\"indoor\":\"false\",\"hardinessZone\":\"7 - 7\",\"wateringBenchmark\":\"Every " +
                "null days\",\"medicinal\":\"false\",\"imgUrl\":" +
                "\"https://perenual.com/storage/species_image/34_acer_palmatum_atrolineare/regular/2560px-Acer_Palmatum_27Red_Pygmy27.jpg\"," +
                "\"description\":\"Ribbon-leaf Japanese Maple (Acer palmatum 'Atrolineare') is a stunningly beautiful specimen of " +
                "maple tree. It features delicate, ribboned-shaped leaves that create a cascading, lacy effect. The leaves emerge " +
                "bright-green in the spring and then deepen to a majestic dark purple for the summer months. It is quite tolerant " +
                "of different conditions and makes an excellent choice for small gardens and as a potted plant. Additionally, its " +
                "slow growth makes it easy to maintain and it shows off its stunning range of colors throughout the season. Perfect " +
                "for adding drama to the garden, Ribbon-leaf Japanese Maple is a must-have for the avid gardener!\"}";

        GetPlantDetailsResponse apiResponse = plantDao.getPlantDetails("34");
        Assertions.assertEquals(apiResponse.getPlantId(), "34");
        Assertions.assertEquals(apiResponse.getPlantName(), "Ribbon-leaf Japanese Maple*");
        Assertions.assertEquals(apiResponse.getScientificName().get(0), "Acer palmatum 'Atrolineare'");

        // WHEN
        cacheClient.put("PlantDetails::34", plantJson);
        String cacheResponse = cacheClient.get("PlantDetails::34");

        // THEN
        Assertions.assertEquals(plantJson, cacheResponse);
    }

    @Test
    public void testCachePutAndGet() {
        CacheClient<Integer, String> cacheClient = new CacheClient<>(3);

        // Test cache put
        cacheClient.put(1, "Value1");
        cacheClient.put(2, "Value2");
        cacheClient.put(3, "Value3");

        // Test cache get
        assertEquals("Value1", cacheClient.get(1));
        assertEquals("Value2", cacheClient.get(2));
        assertEquals("Value3", cacheClient.get(3));
    }

    @Test
    void testCacheEviction() {
        CacheClient<String, String> cacheClient = new CacheClient<>(2);

        cacheClient.put("key1", "value1");
        cacheClient.put("key2", "value2");

        assertNotNull(cacheClient.get("key1"));
        assertNotNull(cacheClient.get("key2"));

        cacheClient.put("key3", "value3");

        assertNull(cacheClient.get("key1"));
    }

    @Test
    void testThreadSafety() throws InterruptedException {
        final CacheClient<String, String> cacheClient = new CacheClient<>(100);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < 1000; i++) {
                executorService.execute(() -> {
                    cacheClient.put("key", "value");
                });
            }

            String cachedValue = cacheClient.get("key");

            assertEquals("value", cachedValue);
        } finally {
            executorService.shutdown();
        }
    }
}
