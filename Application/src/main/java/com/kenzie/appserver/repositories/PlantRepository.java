package com.kenzie.appserver.repositories;

import com.kenzie.appserver.model.CreatePlantRequest;
import com.kenzie.appserver.model.CreatePlantResponse;
import com.kenzie.appserver.repositories.model.PlantRecord;
import com.kenzie.capstone.service.model.GetPlantListResponse;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
@EnableScan
public interface PlantRepository extends CrudRepository<PlantRecord, String> {
}
