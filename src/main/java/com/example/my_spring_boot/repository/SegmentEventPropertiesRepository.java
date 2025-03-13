package com.example.my_spring_boot.repository;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Repository
public interface SegmentEventPropertiesRepository {
    Mono<Optional<Object>> fetchOrgConfig(Integer organisationId);
}
