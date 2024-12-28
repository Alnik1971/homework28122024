package ru.netology.SpringHibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.netology.SpringHibernate.entity.Person;
import ru.netology.SpringHibernate.entity.PersonId;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Component

public class Generator implements CommandLineRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var random = new Random();

        var cities = List.of("Moscow", "Omsk", "Tomsk", "Kirov", "Bryansk");
        var names = List.of("Ivan", "Petya", "Sveta", "Mark", "Alex");
        var surnames = List.of("Ivanov", "Petrov", "Smirnov", "Frolov", "Berg");

        IntStream.range(0,10).forEach(i -> {
            var person = Person.builder().personId(PersonId.builder().name(names.get(random.nextInt(names.size()))).surname(surnames.get(random.nextInt(surnames.size()))).age(random.nextInt(101)).build()).cityOfLiving(cities.get(random.nextInt(cities.size()))).phoneNumber(String.valueOf(random.nextInt(9999999))).build();
            entityManager.persist(person);
        });
    }
}
