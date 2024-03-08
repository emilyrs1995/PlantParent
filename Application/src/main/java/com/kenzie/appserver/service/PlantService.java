package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.PlantRepository;
import com.kenzie.appserver.repositories.model.Plant;
import com.kenzie.appserver.service.model.PlantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlantService {
    @Autowired
    private PlantRepository repository;

    public PlantDTO createPlant(PlantDTO plantDTO) {
        Plant plant = new Plant();
        plant.setPlantId(UUID.randomUUID().toString());
        plant.setPlantName(plantDTO.getPlantName());
        plant.setCycle(plantDTO.getCycle());
        plant.setImgurl(plantDTO.getImgurl());
        plant.setSunlight(plantDTO.getSunlight());
        plant.setWatering(plantDTO.getWatering());

        repository.save(plant);
        plantDTO.setPlantId(plant.getPlantId());
        return plantDTO;
    }

    public PlantDTO findByPlantId(String id) {
        Plant plant = repository.findById(id).orElse(null);
        PlantDTO plantDTO = null;
        if (plant != null) {
            plantDTO = new PlantDTO();
            plantDTO.setSunlight(plant.getSunlight());
            plantDTO.setWatering(plant.getWatering());
            plantDTO.setImgurl(plant.getImgurl());
            plantDTO.setPlantName(plant.getPlantName());
            plantDTO.setPlantId(plant.getPlantId());
            plantDTO.setCycle(plant.getCycle());

        }

        return plantDTO;
    }
}
// delete method