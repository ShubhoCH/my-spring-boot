package com.example.my_spring_boot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoProperties {
    private String host;
    private String database;
    private String username;
    private String password;
}
