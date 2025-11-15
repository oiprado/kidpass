package com.kidpass.studentservice.service;

import com.kidpass.studentservice.entity.Student;
import com.kidpass.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new com.kidpass.studentservice.exception.StudentNotFoundException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student student) {
        Student existingStudent = getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setDateOfBirth(student.getDateOfBirth());
        existingStudent.setGuardianIds(student.getGuardianIds());
        existingStudent.setEnrolledActivityIds(student.getEnrolledActivityIds());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(String id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    public List<Student> getStudentsByGuardianId(String guardianId) {
        return studentRepository.findByGuardianIdsContaining(guardianId);
    }

    public Student addGuardianToStudent(String studentId, String guardianId) {
        Student student = getStudentById(studentId);
        if (student.getGuardianIds() == null) {
            student.setGuardianIds(new java.util.ArrayList<>());
        }
        student.getGuardianIds().add(guardianId);
        return studentRepository.save(student);
    }

    public Student enrollStudentInClass(String studentId, String classId) {
        Student student = getStudentById(studentId);
        if (student.getClassIds() == null) {
            student.setClassIds(new java.util.ArrayList<>());
        }
        student.getClassIds().add(classId);
        return studentRepository.save(student);
    }
}
