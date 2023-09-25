package com.example.springbootcurdwithrestapis.model.tranformers;


import com.example.springbootcurdwithrestapis.model.dtos.StudentDTO;
import com.example.springbootcurdwithrestapis.model.entities.Student;

public class StudentTransformer {

    public static StudentDTO entityToDto(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setEmailId(student.getEmailId());
        studentDTO.setPhoneNo(student.getPhoneNo());
        return studentDTO;
    }
    public static Student dtoToEntity(StudentDTO studentDTO){
        Student student = new Student();
        //BeanUtils.copyProperties(studentDTO,student);
        student.setId(student.getId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmailId(studentDTO.getEmailId());
        student.setPhoneNo(studentDTO.getPhoneNo());
        return student;
    }
}
