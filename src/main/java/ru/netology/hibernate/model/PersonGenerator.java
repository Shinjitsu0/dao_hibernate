package ru.netology.hibernate.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class PersonGenerator implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {
        Random random = new Random();
        List<String> names = List.of("Вова", "Саша", "Олег", "Дима");
        List<String> surnames = List.of("Иванов", "Петров", "Сидоров");
        List<String> cities = List.of("Москва", "Нижний Новгород", "Казань", "Дзержинск");

        IntStream.range(0, 10).forEach(i -> {
            Person person = Person.builder()
                .personKey(PersonKey.builder()
                        .name(names.get(random.nextInt(names.size())))
                        .surname(surnames.get(random.nextInt(surnames.size())))
                        .age(random.nextInt(35))
                        .build())
                .phoneNumber("+79999999999")
                .cityOfLiving(cities.get(random.nextInt(cities.size())))
                .build();
            entityManager.persist(person);
        });
    }
}
