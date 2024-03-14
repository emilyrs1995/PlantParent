package com.kenzie.capstone.service.dependency;

import com.kenzie.capstone.service.caching.CacheClient;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class CachingModule {

    @Singleton
    @Provides
    public CacheClient<Integer, String> provideCacheClient() {
        int maxSize = 5;
        return new CacheClient<>(maxSize);
    }
}
