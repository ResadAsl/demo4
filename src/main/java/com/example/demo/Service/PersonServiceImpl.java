package com.example.demo.Service;

import com.example.demo.DTO.PersonCreateDTO;
import com.example.demo.DTO.PersonUptadeDTO;
import com.example.demo.DTO.PersonViewDTO;
import com.example.demo.Entity.Person;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonViewDTO getPersonById(long id) {
      final Person person =     personRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return PersonViewDTO.of(person );
    }

    @Override
    public PersonViewDTO createPerson(PersonCreateDTO personCreateDTO) {


       final   Person person  = personRepository.save(
               new Person(personCreateDTO.getFirstName(),
                         personCreateDTO.getLastName(),
                        personCreateDTO.getGender(),
                        personCreateDTO.getHeight()));



        return PersonViewDTO.of(person);
    }

    @Override
    @Transactional
    public PersonViewDTO uptadePerson(Long id, PersonUptadeDTO personUptadeDTO) {

        final Person person = personRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));

        person.setFirstName(personUptadeDTO.getFirstName());
        person.setLastName(personUptadeDTO.getLastName());
        person.setGender(personUptadeDTO.getGender());
        person.setHeight(personUptadeDTO.getHeight());

        final  Person uptadePerson = personRepository.save(person);

        return PersonViewDTO.of(uptadePerson);
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        final Person person = personRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));

        personRepository.deleteById(person.getId());

    }

    @Override
    public List<PersonViewDTO> getPersons() {

        return personRepository.findAll().stream().map(PersonViewDTO::of).collect(Collectors.toList());
    }
}
