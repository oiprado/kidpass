package com.kidpass.studentservice.service;

import com.kidpass.studentservice.entity.SchoolClass;
import com.kidpass.studentservice.repository.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    public List<SchoolClass> getAllClasses() {
        return schoolClassRepository.findAll();
    }

    public SchoolClass getClassById(String id) {
        return schoolClassRepository.findById(id).orElse(null);
    }

    public SchoolClass createClass(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    public void deleteClass(String id) {
        schoolClassRepository.deleteById(id);
    }
}
