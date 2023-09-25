package com.example.springbootcurdwithrestapis.service;

import com.example.springbootcurdwithrestapis.exceptions.ResourceNotFoundException;
import com.example.springbootcurdwithrestapis.model.entities.Student;
import com.example.springbootcurdwithrestapis.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public ResponseEntity<String> updateStudent(Long id , Student student) {
        Student updatedStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("student is not exist with "+id));
            updatedStudent.setFirstName(student.getFirstName());
            updatedStudent.setLastName(student.getLastName());
            updatedStudent.setEmailId(student.getEmailId());
            updatedStudent.setPhoneNo(student.getPhoneNo());
            updatedStudent.setAddress(student.getAddress());
            studentRepository.save(updatedStudent);
             return ResponseEntity.ok().body("Student Details Updated ..");
    }

    @Override
    public ResponseEntity<String> deleteStudentById(Long id) {
        Student student = getStudentById(id);
       if(student.getId().equals(id)){ studentRepository.deleteById(id);}
        return ResponseEntity.ok().body("Student is Deleted successfully");
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("student is not exist with "+id));
        return student;
    }
}
