package com.example.springbootcurdwithrestapis.repository;

import com.example.springbootcurdwithrestapis.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
//    Optional<Object> findAllByEmailId(Long id);
}
