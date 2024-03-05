package com.kenzie.capstone.service.dependency;

import com.kenzie.capstone.service.caching.CacheClient;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;

@Module
public class CachingModule {

    @Provides
    @Singleton
    @Named("CacheClient")
    public CacheClient provideCacheClient() {
        return new CacheClient();
    }
}
