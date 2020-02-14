package com.cbnits.springboot_demo.repository;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @GetMapping
    public String defaultPage() {
        return "Hello! This is my first API";
    }

    /*@GetMapping("v1")
    public String defaultPageV1() {
        return "Hello! This is my first V1 API";
    }*/

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "v1", produces = MediaType.APPLICATION_JSON_VALUE)
    public String defaultPageInputParam(
            @RequestParam(required = false, name = "m", defaultValue = "Default message") String messages,
            @RequestParam(required = false, name = "o", defaultValue = "hello") String other,
            @RequestParam Integer number
    ) {
//        throw new NullPointerException("Something Bad Happens");
        return "Hello! This is my first V1 API. Messages : " + messages + " " + other;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("v1")
    public String postMethodTest(
            @RequestParam(required = false, name = "m", defaultValue = "Default message") String messages,
            @RequestParam(required = false, name = "o", defaultValue = "hello") String other,
            @RequestParam Integer number
    ) {
        return "My first POST Method";
    }

    @PutMapping("v1")
    public String putMethodTest(
            @RequestParam(required = false, name = "m", defaultValue = "Default message") String messages,
            @RequestParam(required = false, name = "o", defaultValue = "hello") String other,
            @RequestParam Integer number
    ) {
        return "My first PUT Method";
    }

    @DeleteMapping("v1")
    public String deleteMethodTest(
            @RequestParam(required = false, name = "m", defaultValue = "Default message") String messages,
            @RequestParam(required = false, name = "o", defaultValue = "hello") String other,
            @RequestParam Integer number
    ) {
        return "My first Delete Method";
    }
}
