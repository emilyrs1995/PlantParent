package com.kenzie.capstone.service.caching;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheClient<K, V> {
    private final Map<K, V> cache;

    public CacheClient(int maxSize) {
        this.cache = new LinkedHashMap<K, V>(maxSize + 1, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxSize;
            }
        };
    }

    public synchronized void put(K key, V value) {
        cache.put(key, value);
    }

    public synchronized V get(K key) {
        return cache.get(key);
    }

    public synchronized void remove(K key) {
        cache.remove(key);
    }

    public synchronized void clear() {
        cache.clear();
    }

    public synchronized int size() {
        return cache.size();
    }
}
