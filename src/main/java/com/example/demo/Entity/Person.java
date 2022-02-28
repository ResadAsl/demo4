package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "firstName",  nullable = false, length = 100)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @Column(name = "height", nullable = false,length = 100)
    private double height;


    public Person(String firstName, String lastName, String gender, double height) {
        this.firstName=firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.height  = height;
    }

    public Person() {
    }

}
