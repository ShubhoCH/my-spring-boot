package com.example.my_spring_boot.controller;

import com.example.my_spring_boot.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final WeatherService weatherService;

    @Autowired
    public PostController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/fetch-posts")
    public Mono<List<String>> fetchPosts() {
        return weatherService.fetchPosts();
    }

    @PostMapping("/fetch-comments")
    public Mono<List<String>> fetchComments() {
        return weatherService.fetchComments();
    }
}
