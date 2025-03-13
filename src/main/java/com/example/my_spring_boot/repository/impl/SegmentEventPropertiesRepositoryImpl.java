package com.example.my_spring_boot.repository.impl;

import com.example.my_spring_boot.repository.SegmentEventPropertiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public class SegmentEventPropertiesRepositoryImpl implements SegmentEventPropertiesRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public SegmentEventPropertiesRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<Optional<Object>> fetchOrgConfig(Integer organisationId) {
        return Mono.fromCallable(() -> {

            Query query = new Query(Criteria.where("organisation_id").is(organisationId));
            Object result = mongoTemplate.findOne(query, Object.class, "segment_event_properties_status");
            return Optional.ofNullable(result);
        });
    }
}
