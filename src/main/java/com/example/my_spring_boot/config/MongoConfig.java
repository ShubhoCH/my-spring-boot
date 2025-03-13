package com.example.my_spring_boot.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        String mongoUri = "mongodb://root:root@localhost:27017/?tls=false";

        return MongoClients.create(mongoUri);
    }
}