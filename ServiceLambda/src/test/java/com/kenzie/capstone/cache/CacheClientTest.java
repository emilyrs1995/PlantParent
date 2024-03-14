package com.kenzie.capstone.cache;

import com.kenzie.capstone.service.caching.CacheClient;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

public class CacheClientTest {

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
