package com.example.springbootcurdwithrestapis.repository;

import com.example.springbootcurdwithrestapis.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
