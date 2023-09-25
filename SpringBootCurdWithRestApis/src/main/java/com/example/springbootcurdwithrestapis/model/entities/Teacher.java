package com.example.springbootcurdwithrestapis.model.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")    
    private List<Student> students;

}
