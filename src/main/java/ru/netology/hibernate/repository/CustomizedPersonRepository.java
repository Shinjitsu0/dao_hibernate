package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.hibernate.model.Person;
import ru.netology.hibernate.model.PersonKey;

import java.util.List;
import java.util.Optional;

public interface CustomizedPersonRepository extends JpaRepository<Person, PersonKey> {
    List<Person> findByCityOfLiving(String cityOfLiving);
    List<Person> findAllByPersonKey_AgeLessThanOrderByPersonKey_Age(int age);
    Optional<Person> findPersonByPersonKey_NameAndPersonKey_Surname(String name, String surname);
}
