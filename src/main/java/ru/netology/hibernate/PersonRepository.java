package ru.netology.hibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Transactional
@Repository
public class PersonRepository implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run(String... args) {
        Random random = new Random();
        List<String> names = List.of("Вова", "Саша", "Олег", "Дима");
        List<String> surnames = List.of("Иванов", "Петров", "Сидоров");
        List<String> cities = List.of("Москва", "Нижний Новгород", "Казань", "Дзержинск");

        IntStream.range(0, 10).forEach(i -> {Person person = Person.builder()
        .name(names.get(random.nextInt(names.size())))
        .surname(surnames.get(random.nextInt(surnames.size())))
        .age(random.nextInt(35))
        .phoneNumber("+79999999999")
        .cityOfLiving(cities.get(random.nextInt(cities.size())))
        .build();
        entityManager.persist(person);
        });
    }

    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> query = entityManager.createQuery
                ("select city from Person city where city.cityOfLiving =:city",
                        Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
