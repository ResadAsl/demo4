package com.example.demo.Service;

import com.example.demo.DTO.PersonCreateDTO;
import com.example.demo.DTO.PersonUptadeDTO;
import com.example.demo.DTO.PersonViewDTO;
import com.example.demo.Entity.Person;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PersonService {

    PersonViewDTO getPersonById(long id);

    List<PersonViewDTO> getPersons();

    PersonViewDTO createPerson(PersonCreateDTO personCreateDTO);

    PersonViewDTO uptadePerson(Long id, PersonUptadeDTO personUptadeDTO);

    void deletePerson(Long id);


}
