package ru.egor.megademo230907.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.egor.megademo230907.db.FakeDB;

import java.util.stream.Collectors;

@RestController
public class Hello {


    private FakeDB fakeDB;

    @Autowired
    public Hello(FakeDB fakeDB) {
        this.fakeDB = fakeDB;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello!";
    }


    @GetMapping("/bot")
    public String botMsg(){
        return fakeDB.all().stream().map( e-> e.getUser() + " " + e.getMessage()).collect(Collectors.joining("\n"));

    }
}
