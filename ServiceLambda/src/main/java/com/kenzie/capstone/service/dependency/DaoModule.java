package com.kenzie.capstone.service.dependency;


import com.kenzie.capstone.service.caching.CacheClient;
import com.kenzie.capstone.service.caching.CachingPlantDao;
import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.dao.PlantDao;
import com.kenzie.capstone.service.util.DynamoDbClientProvider;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Provides DynamoDBMapper instance to DAO classes.
 */
@Module(includes = CachingModule.class)
public class DaoModule {

    @Singleton
    @Provides
    @Named("CacheClient")
    public CacheClient<String, String> provideCacheClient() {
        return new CacheClient<>(10);
    }

    @Singleton
    @Provides
    @Named("DynamoDBMapper")
    public DynamoDBMapper provideDynamoDBMapper() {
        return new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient());
    }

    @Singleton
    @Provides
    @Named("PlantDao")
    @Inject
    public PlantDao providePlantDao(@Named("CacheClient") CacheClient<String, String> cacheClient,
                                    @Named("NonCachingPlantDao") NonCachingPlantDao nonCachingPlantDao) {
        return new CachingPlantDao(cacheClient, nonCachingPlantDao);
    }

    @Singleton
    @Provides
    @Named("NonCachingPlantDao")
    @Inject
    public NonCachingPlantDao provideNonCachingPlantDao() {
        return new NonCachingPlantDao();
    }
}
