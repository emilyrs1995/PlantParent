package com.kenzie.capstone.service.dao;

import com.kenzie.capstone.service.model.GetPlantListResponse;

import java.util.List;

public interface PlantDao {

    List<GetPlantListResponse> getPlantList(String plantName);
}
