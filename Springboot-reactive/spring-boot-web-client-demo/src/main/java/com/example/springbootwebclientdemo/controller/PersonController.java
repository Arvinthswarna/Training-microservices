package com.example.springbootwebclientdemo.controller;

import com.example.springbootwebclientdemo.model.Person;
import com.example.springbootwebclientdemo.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonServiceImpl personServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person>create(@RequestBody Person person){
        return personServiceImpl.create(person);
    }
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Person>findAll(){
        return personServiceImpl.findAll();
    }
    @GetMapping(value = "/{id}")
    public Mono<Person>finById(@PathVariable("id") Integer id){
        return personServiceImpl.findById(id);
    }


}
