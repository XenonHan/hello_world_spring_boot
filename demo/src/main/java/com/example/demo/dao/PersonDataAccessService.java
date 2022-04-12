package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public UUID insertPerson(UUID uuid, Person person) {
        final String sql = "INSERT INTO person (id, name) VALUES (?,?)";
        int flag = jdbcTemplate.update(
                sql,
                uuid,
                person.getName()
        );
        return flag == 1 ? uuid : null;
    }

    @Override
    public List<Person> getAllPerson() {
        final String sql = "SELECT id, name FROM person";
        return jdbcTemplate.query(
                sql,
                (resultSet, i) -> {
                    UUID id = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    return new Person(id, name);
                });
    }

    @Override
    public void deletePerson(UUID id) {
        final String sql = "DELETE FROM person WHERE id = ?";
        jdbcTemplate.update(
                sql,
                id
        );
    }

    @Override
    public void updatePerson(UUID id, Person person) {
        final String sql = "UPDATE person SET name = ? WHERE id = ?";
        jdbcTemplate.update(
                sql,
                person.getName(),
                id
        );
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(
                sql,
                (resultSet, i) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    return new Person(personId, name);
                },
                id
        );
        return Optional.ofNullable(person);
    }
}
