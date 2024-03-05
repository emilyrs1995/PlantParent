package com.kenzie.capstone.service;

import com.kenzie.capstone.service.dao.PlantDao;
import com.kenzie.capstone.service.exceptions.InvalidDataException;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.util.List;

public class PlantListLambdaService {

    private PlantDao plantDao;

    @Inject
    public PlantListLambdaService(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    public List<GetPlantListResponse> getPlantList(String plantName) {
        if (plantName == null || plantName.length() == 0) {
            throw new InvalidDataException("PlantName cannot be null or empty.");
        }

        return plantDao.getPlantList(plantName);
    }
}
