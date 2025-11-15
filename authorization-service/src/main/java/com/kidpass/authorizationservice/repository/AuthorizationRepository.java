package com.kidpass.authorizationservice.repository;

import com.kidpass.authorizationservice.entity.Authorization;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorizationRepository extends MongoRepository<Authorization, String> {

    List<Authorization> findByUserId(String userId);
    List<Authorization> findByStudentId(String studentId);
}
