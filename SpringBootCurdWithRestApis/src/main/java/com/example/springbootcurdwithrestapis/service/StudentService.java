package com.example.springbootcurdwithrestapis.service;

import com.example.springbootcurdwithrestapis.model.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    Student createStudent(Student student);
    ResponseEntity<String> updateStudent(Long id, Student student);
    ResponseEntity<String> deleteStudentById(Long id);
    Student getStudentById(Long id);

}
