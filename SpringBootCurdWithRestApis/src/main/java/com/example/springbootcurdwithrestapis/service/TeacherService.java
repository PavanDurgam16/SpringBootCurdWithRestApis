package com.example.springbootcurdwithrestapis.service;


import com.example.springbootcurdwithrestapis.model.entities.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAll();
    Teacher createTeacher(Teacher teacher);
    ResponseEntity<Teacher> updateTeacher(Long id, Teacher teacher);
    ResponseEntity<Teacher> deleteTeacherById(Long id);
    Teacher getTeacherById(Long id);
}
