package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
@SuppressWarnings("unused")
public class fakePersonDataAccessService implements PersonDao {
    static private final List<Person> DB = new ArrayList<>();

    @Override
    public UUID insertPerson(UUID uuid, Person person) {
        DB.add(new Person(uuid, person.getName()));
        return uuid;
    }

    @Override
    public List<Person> getAllPerson() {
        return DB;
    }

    @Override
    public void deletePerson(UUID id) {
        Optional<Person> deletePerson = selectPersonById(id);
        deletePerson.ifPresent(DB::remove);
    }

    @Override
    public void updatePerson(UUID id, Person person) {
        selectPersonById(id)
                .map(
                        p -> {
                            int indexOfPerson = DB.indexOf(p);
                            if (indexOfPerson == -1)
                                return false;
                            DB.set(indexOfPerson, new Person(id, person.getName()));
                            return true;
                        }
                );
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }
}
