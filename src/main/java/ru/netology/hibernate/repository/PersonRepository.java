package ru.netology.hibernate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hibernate.model.Person;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class PersonRepository {

    private final CustomizedPersonRepository customizedPersonRepository;

    public PersonRepository(CustomizedPersonRepository customizedPersonRepository) {
        this.customizedPersonRepository = customizedPersonRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return customizedPersonRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAge(int age) {
        return customizedPersonRepository.findAllByPersonKey_AgeLessThanOrderByPersonKey_Age(age);
    }

    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        return customizedPersonRepository.findPersonByPersonKey_NameAndPersonKey_Surname(name, surname);
    }
}
