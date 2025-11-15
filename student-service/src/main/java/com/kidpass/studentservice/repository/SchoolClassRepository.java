package com.kidpass.studentservice.repository;

import com.kidpass.studentservice.entity.SchoolClass;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchoolClassRepository extends MongoRepository<SchoolClass, String> {
}
