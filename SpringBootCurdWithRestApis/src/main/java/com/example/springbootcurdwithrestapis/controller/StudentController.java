package com.example.springbootcurdwithrestapis.controller;


import com.example.springbootcurdwithrestapis.model.entities.Student;
import com.example.springbootcurdwithrestapis.service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentController {

    private final StudentServiceImpl service;

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student){
        service.createStudent(student);
        return "student is created successfully";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudentById(@PathVariable Long id , @RequestBody Student studentDetails){
        return service.updateStudent(id,studentDetails);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id ){
        return service.deleteStudentById(id);
    }

    @GetMapping("/students/{id}")
    public Student getById(@PathVariable Long id){
        return service.getStudentById(id);
    }
}
