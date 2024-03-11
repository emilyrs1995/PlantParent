package com.kenzie.appserver.config;

import com.kenzie.capstone.service.client.PlantListLambdaServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LambdaServiceClientConfiguration {

    @Bean
    public PlantListLambdaServiceClient plantListLambdaServiceClient() {
        return new PlantListLambdaServiceClient();
    }
}
