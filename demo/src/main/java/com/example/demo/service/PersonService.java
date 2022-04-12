package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {

        this.personDao = personDao;
    }
    @SuppressWarnings("UnusedReturnValue")
    public UUID addPerson(Person person){
        return this.personDao.insertPerson(person);
    }

    public List<Person> getAllPerson(){
        return personDao.getAllPerson();
    }

    public Optional<Person> selectPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public boolean deletePeron(UUID id){
       return personDao.deletePerson(id);
    }

    public boolean updatePerson(UUID id, Person person){
        return personDao.updatePerson(id, person);
    }
}
