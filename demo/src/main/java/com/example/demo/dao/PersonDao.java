package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    UUID insertPerson(UUID uuid, Person person);

    default UUID insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getAllPerson();

    boolean deletePerson(UUID id);

    boolean updatePerson(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);

}
