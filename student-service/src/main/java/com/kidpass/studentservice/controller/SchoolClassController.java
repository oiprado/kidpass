package com.kidpass.studentservice.controller;

import com.kidpass.studentservice.entity.SchoolClass;
import com.kidpass.studentservice.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class SchoolClassController {

    @Autowired
    private SchoolClassService schoolClassService;

    @GetMapping
    public List<SchoolClass> getAllClasses() {
        return schoolClassService.getAllClasses();
    }

    @GetMapping("/{id}")
    public SchoolClass getClassById(@PathVariable String id) {
        return schoolClassService.getClassById(id);
    }

    @PostMapping
    public SchoolClass createClass(@RequestBody SchoolClass schoolClass) {
        return schoolClassService.createClass(schoolClass);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable String id) {
        schoolClassService.deleteClass(id);
    }
}
