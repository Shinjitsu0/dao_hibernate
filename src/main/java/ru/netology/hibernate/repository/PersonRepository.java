package ru.netology.hibernate.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hibernate.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Person> getPersonsByCity(String city) {
        TypedQuery<Person> query = entityManager.createQuery
                ("select city from Person city where city.cityOfLiving =:city",
                        Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
