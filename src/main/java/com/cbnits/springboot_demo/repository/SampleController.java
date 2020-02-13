package com.cbnits.springboot_demo.repository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("v1")
    public String defaultPageInputParam(
            @RequestParam(required = false, name = "m", defaultValue = "Default message") String messages,
            @RequestParam(required = false, name = "o", defaultValue = "hello") String other,
            @RequestParam Integer number
    ) {
        return "Hello! This is my first V1 API. Messages : " + messages + " " + other;
    }
}
