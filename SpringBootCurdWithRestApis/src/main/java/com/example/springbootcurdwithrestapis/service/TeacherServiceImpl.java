package com.example.springbootcurdwithrestapis.service;

import com.example.springbootcurdwithrestapis.exceptions.ResourceNotFoundException;
import com.example.springbootcurdwithrestapis.model.entities.Teacher;
import com.example.springbootcurdwithrestapis.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public ResponseEntity<Teacher> updateTeacher(Long id, Teacher teacher) {
        Teacher existedTeacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher is not exist with "+id));
        if(existedTeacher.getId().equals(id)){
            existedTeacher.setFirstName(teacher.getFirstName());
            existedTeacher.setLastName(teacher.getLastName());
            existedTeacher.setEmailId(teacher.getEmailId());
            existedTeacher.setPhoneNo(teacher.getPhoneNo());
            existedTeacher.setStudents(teacher.getStudents());
            return ResponseEntity.ok().body(existedTeacher);
        }
        return ResponseEntity.badRequest().body(teacher);
    }

    @Override
    public ResponseEntity<Teacher> deleteTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher is not exist with "+id));
        teacherRepository.deleteById(teacher.getId());
        return ResponseEntity.badRequest().body(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("student is not exist with "+id));
        return teacher;
    }
}
