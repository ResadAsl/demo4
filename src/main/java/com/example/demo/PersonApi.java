package com.example.demo;

import com.example.demo.DTO.PersonCreateDTO;
import com.example.demo.DTO.PersonUptadeDTO;
import com.example.demo.DTO.PersonViewDTO;
import com.example.demo.Service.PersonService;
import com.example.demo.shared.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PersonApi {

    private final PersonService personService;

    @GetMapping("v1/person/{id}")

    public ResponseEntity<PersonViewDTO> getPersonById(@PathVariable long id){
        PersonViewDTO person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }


    @GetMapping("v1/person")

    public ResponseEntity<List<PersonViewDTO>> getPersons(){
        final List<PersonViewDTO> persons =  personService.getPersons();

        return ResponseEntity.ok(persons);
    }


    @PostMapping("v1/person")

    public ResponseEntity<?> createPerson (@RequestBody PersonCreateDTO personCreateDTO){

        personService.createPerson(personCreateDTO);
        return ResponseEntity.ok(new GenericResponse("Person Created"));
    }


    @PutMapping("v1/person/{id}")
     public ResponseEntity<PersonViewDTO>  uptadePerson(@PathVariable("id") Long id, @RequestBody PersonUptadeDTO personUptadeDTO){

        final PersonViewDTO person  =  personService.uptadePerson(id, personUptadeDTO);

        return ResponseEntity.ok(person);
    }

    @DeleteMapping("v1/person/{id}")

    public ResponseEntity<?> deletePerson(@PathVariable("id") Long id){

     personService.deletePerson(id);

     return ResponseEntity.ok(new GenericResponse("Person Delete!"));


    }


}
