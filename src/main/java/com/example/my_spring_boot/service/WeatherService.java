package com.example.my_spring_boot.service;

import com.example.my_spring_boot.model.Comment;
import com.example.my_spring_boot.model.Post;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WeatherService {

    private final WebClient webClient;

    private final MongoCollection<Document> myCollection;

    public WeatherService(WebClient.Builder webClientBuilder, MongoClient mongoClient) {
        this.webClient = webClientBuilder.baseUrl("http://jsonplaceholder.typicode.com").build();
        MongoDatabase database = mongoClient.getDatabase("integrations");
        this.myCollection = database.getCollection("segment_event_properties_status");
    }

    public Mono<List<String>> fetchPosts() {
        FindIterable<Document> documents = myCollection.find();

        // Print all documents
        for (Document doc : documents) {
            System.out.println(doc.toJson());
        }
        return webClient.get()
                .uri("/posts")
                .retrieve()
                .bodyToFlux(Post.class)
                .filter(post -> post.getId() % 2 == 0)
                .map(Post::getTitle)
                .collectList();
    }

    public Mono<List<String>> fetchComments() {
        return webClient.get()
                .uri("/comments")
                .retrieve()
                .bodyToFlux(Comment.class)
                .map(Comment::getBody) // Extract comment bodies
                .collectList();
    }
}
