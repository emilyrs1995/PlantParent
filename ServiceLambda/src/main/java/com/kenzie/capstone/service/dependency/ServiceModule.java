package com.kenzie.capstone.service.dependency;

import com.kenzie.capstone.service.PlantListLambdaService;

import com.kenzie.capstone.service.caching.CacheClient;
import com.kenzie.capstone.service.caching.CachingPlantDao;
import com.kenzie.capstone.service.dao.NonCachingPlantDao;
import com.kenzie.capstone.service.dao.PlantDao;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Module(includes = DaoModule.class)
public class ServiceModule {

    @Singleton
    @Provides
    @Inject
    public PlantListLambdaService providePlantListLambdaService(@Named("PlantDao") PlantDao plantDao) {
        return new PlantListLambdaService(plantDao);
    }
}

