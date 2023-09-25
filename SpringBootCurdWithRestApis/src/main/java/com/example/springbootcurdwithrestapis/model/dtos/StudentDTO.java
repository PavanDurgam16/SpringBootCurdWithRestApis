package com.example.springbootcurdwithrestapis.model.dtos;

import lombok.Data;

@Data
public class StudentDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private Long phoneNo;
}
