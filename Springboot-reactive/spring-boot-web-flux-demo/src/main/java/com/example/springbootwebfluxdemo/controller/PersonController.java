package com.example.springbootwebfluxdemo.controller;

import com.example.springbootwebfluxdemo.model.Person;
import com.example.springbootwebfluxdemo.service.PersonServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {
    @Autowired
    PersonServiceimpl personServiceimpl;

    @PostMapping("/create/person")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPerson(@RequestBody Person person) {
        personServiceimpl.createPerson(person);
    }

    @GetMapping(value = "/get/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> findall() {
        return personServiceimpl.findAllPerson();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Mono<Person>>findPersonById(@PathVariable("id") Integer id) {
        Mono<Person> person = personServiceimpl.findByPersonId(id);
        return new ResponseEntity<Mono<Person>>(person, person != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}