package com.kenzie.appserver.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.google.common.collect.Table;
import com.kenzie.appserver.repositories.PlantRepository;
import com.kenzie.appserver.repositories.model.Plant;
import com.kenzie.appserver.service.model.PlantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PlantService {
//    @Autowired
//    private PlantRepository repository;
//    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
//            .withRegion(Regions.US_EAST_1).build();
//    DynamoDB dynamoDB = new DynamoDB(client);
//    public PlantDTO createPlant(PlantDTO plantDTO) {
//        Plant plant = new Plant();
//        plant.setPlantId(UUID.randomUUID().toString());
//        plant.setPlantName(plantDTO.getPlantName());
//        plant.setCycle(plantDTO.getCycle());
//        plant.setImgurl(plantDTO.getImgurl());
//        plant.setSunlight(plantDTO.getSunlight());
//        plant.setWatering(plantDTO.getWatering());
//        repository.save(plant);
//        plantDTO.setPlantId(plant.getPlantId());
//        return plantDTO;
//    }
//    public PlantDTO findByPlantId(String id) {
//        Plant plant = repository.findById(id).orElse(null);
//        PlantDTO plantDTO = null;
//        if (plant != null) {
//            plantDTO = new PlantDTO();
//            plantDTO.setSunlight(plant.getSunlight());
//            plantDTO.setWatering(plant.getWatering());
//            plantDTO.setImgurl(plant.getImgurl());
//            plantDTO.setPlantName(plant.getPlantName());
//            plantDTO.setPlantId(plant.getPlantId());
//            plantDTO.setCycle(plant.getCycle());
//        }
//        return plantDTO;
//    }
//    public List<PlantDTO> findAll() {
//        List<PlantDTO> plantsDTO = new ArrayList<>();
//        repository.findAll().forEach(plant -> {
//            PlantDTO plantDTO = new PlantDTO();
//            plantDTO.setSunlight(plant.getSunlight());
//            plantDTO.setWatering(plant.getWatering());
//            plantDTO.setImgurl(plant.getImgurl());
//            plantDTO.setPlantName(plant.getPlantName());
//            plantDTO.setPlantId(plant.getPlantId());
//            plantDTO.setCycle(plant.getCycle());
//            plantsDTO.add(plantDTO);
//        });
//        return plantsDTO;
//    }
//    public void delete(String id) {
//        repository.deleteById(id);
//    }
//    public PlantDTO findByName(String name) {
//        Table table = dynamoDB.getTable("Plant");
//        QuerySpec spec = new QuerySpec()
//                .withKeyConditionExpression("PlantName = :v_nome")
//                .withValueMap(new ValueMap()
//                .withString(":v_nome", name));
//        ItemCollection<QueryOutcome> items = table.query(spec);
//        Iterator<Item> iterator = items.iterator();
//        Item item = null;
//        if (iterator.hasNext()) {
//            item = iterator.next();
//            return findByPlantId(item.getString("PlantId"));
//        }
//        return null;
//    }
    //type of id is actulally String
}
// delete method
