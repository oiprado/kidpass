package com.kidpass.studentservice.repository;

import com.kidpass.studentservice.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByGuardianIdsContaining(String guardianId);
}
