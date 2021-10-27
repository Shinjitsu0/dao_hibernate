package ru.netology.hibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/persons/by-age")
    public List<Person> getListPersonByAge(int age) {
        return personRepository.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-person")
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.getPersonsByNameAndSurname(name, surname);
    }
}
