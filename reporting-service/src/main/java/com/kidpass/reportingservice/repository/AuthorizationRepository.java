package com.kidpass.reportingservice.repository;

import com.kidpass.reportingservice.entity.Authorization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorizationRepository extends MongoRepository<Authorization, String> {
}
