package com.example.demo.DTO;

import com.example.demo.Entity.Person;
import lombok.Getter;

import java.io.Serializable;

@Getter
public final class PersonViewDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String firstName;

    private final String lastName;

    private final String gender;

    private final double height;


    public PersonViewDTO(String firstName, String lastName, String gender, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.height = height;
    }

    public static PersonViewDTO of(Person person){

        return new PersonViewDTO(person.getFirstName(), person.getLastName(), person.getGender(), person.getHeight());
    }
}
