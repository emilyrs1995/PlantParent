package com.kenzie.appserver.repositories;

import com.kenzie.appserver.repositories.model.PlantRecord;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface PlantRepository extends CrudRepository<PlantRecord, String> {
}
