package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

public class PersonService {
    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return this.personDao.insertPerson(person);
    }
}
