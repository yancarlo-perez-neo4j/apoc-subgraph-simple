package com.example.demo.controller;

import com.example.demo.person.Person;
import com.example.demo.person.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/knows/{name}")
    Flux<Person> getSubGraph(@PathVariable String name) {
        return personRepository.getSubGraph(name);
    }
}
