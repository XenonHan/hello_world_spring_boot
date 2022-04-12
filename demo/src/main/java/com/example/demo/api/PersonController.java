package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public UUID addPerson(@Valid @NotBlank @RequestBody Person person) {
        return this.personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping(path = "{id}")
    public Person selectPerson(@PathVariable("id") UUID id) {
        return personService.selectPersonById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public String updatePerson(@PathVariable("id") UUID id, @Valid @NotBlank @RequestBody Person person) {
        return personService.updatePerson(id, person) ? "success" : "fail";
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        personService.deletePeron(id);
    }

}
