package com.kidpass.studentservice.controller;

import com.kidpass.studentservice.entity.Student;
import com.kidpass.studentservice.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/guardian/{guardianId}")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Student> getStudentsByGuardianId(@PathVariable String guardianId) {
        return studentService.getStudentsByGuardianId(guardianId);
    }

    @PutMapping("/{studentId}/add-guardian/{guardianId}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Student addGuardianToStudent(@PathVariable String studentId, @PathVariable String guardianId) {
        return studentService.addGuardianToStudent(studentId, guardianId);
    }

    @PutMapping("/{studentId}/enroll/{classId}")
    //@PreAuthorize("hasRole('ADMIN')")
    public Student enrollStudentInClass(@PathVariable String studentId, @PathVariable String classId) {
        return studentService.enrollStudentInClass(studentId, classId);
    }
}