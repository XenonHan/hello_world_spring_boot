package com.example.demo.model;

import com.example.demo.dao.PersonDao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class fakePersonDataAccessService implements PersonDao {
    static private List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID uuid, Person person) {
        DB.add(new Person(uuid, person.getName()));
        return 1;
    }
}
