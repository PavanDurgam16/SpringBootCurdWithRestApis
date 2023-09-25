package com.example.springbootcurdwithrestapis.model.entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;



}
