package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;

@RestController
public class Controller {
    public PersonRepository personRepository;

    public Controller(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getListPersonByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}
