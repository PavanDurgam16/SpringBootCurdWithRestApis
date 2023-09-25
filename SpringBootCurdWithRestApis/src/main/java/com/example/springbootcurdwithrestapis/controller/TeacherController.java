package com.example.springbootcurdwithrestapis.controller;


import com.example.springbootcurdwithrestapis.model.entities.Teacher;
import com.example.springbootcurdwithrestapis.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teachers")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return teacherService.createTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacherById(@PathVariable Long id , @RequestBody Teacher teacherDetails){
        return teacherService.updateTeacher(id,teacherDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Teacher> deleteTeacher(@PathVariable Long id ){
        return teacherService.deleteTeacherById(id);
    }

    @GetMapping("/{id}")
    public Teacher getById(@PathVariable Long id){
        return teacherService.getTeacherById(id);
    }
}
