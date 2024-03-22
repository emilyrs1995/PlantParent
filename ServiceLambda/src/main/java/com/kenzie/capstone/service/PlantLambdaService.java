package com.kenzie.capstone.service;

import com.kenzie.capstone.service.dao.PlantDao;
import com.kenzie.capstone.service.exceptions.InvalidDataException;
import com.kenzie.capstone.service.model.GetPlantDetailsResponse;
import com.kenzie.capstone.service.model.GetPlantListResponse;

import javax.inject.Inject;
import java.util.List;

public class PlantLambdaService {

    private PlantDao plantDao;

    @Inject
    public PlantLambdaService(PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    public List<GetPlantListResponse> getPlantList(String plantName) {
        if (plantName == null || plantName.length() == 0) {
            throw new InvalidDataException("PlantName cannot be null or empty.");
        }

        return plantDao.getPlantList(plantName);
    }

    public GetPlantDetailsResponse getPlantDetails(String id) {
        if (id == null || id.length() == 0) {
            throw new InvalidDataException("The Plant Id cannot be null or empty.");
        }
        return plantDao.getPlantDetails(id);
    }
}
