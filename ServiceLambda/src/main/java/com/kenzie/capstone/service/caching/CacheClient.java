package com.kenzie.capstone.service.caching;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheClient<K, V> {
    private final Cache<K, V> cache;

    public CacheClient(int maxSize) {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(maxSize)
                .build();
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.getIfPresent(key);
    }

    public void remove(K key) {
        cache.invalidate(key);
    }

    public void clear() {
        cache.invalidateAll();
    }

    public int size() {
        return (int) cache.size();
    }
}
