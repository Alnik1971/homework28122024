package ru.netology.SpringHibernate.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import ru.netology.SpringHibernate.entity.Person;
import ru.netology.SpringHibernate.repository.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)

@AllArgsConstructor

@org.springframework.stereotype.Service
public class Service {
    private Repository repository;

    public Service(Repository repository){
        this.repository = repository;
    }

    public List<Person> getPersonByCity(String city){return repository.findPersonByCityOfLiving(city);
    }
    public List<Person> getPersonByAge(int age) {return repository.findAllByPersonId_AgeLessThanOrderByPersonId_Age(age);
    }
    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return repository.findPersonByPersonId_NameAndPersonId_Surname(name, surname);
    }
}
