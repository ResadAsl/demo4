package com.example.demo.DTO;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PersonCreateDTO {



    private String firstName;

    private String lastName;

    private String gender;

    private double height;
}
