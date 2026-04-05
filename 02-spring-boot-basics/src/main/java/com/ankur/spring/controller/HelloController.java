package com.ankur.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloController {

    // Example: http://localhost:8080/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Ankur";
    }

    // Example: http://localhost:8080/hello-param?name=Ankur
    @GetMapping("/hello-param")
    public String sayHelloReqString(@RequestParam String name) {
        return "Hello " + name;
    }

    // Example: http://localhost:8080/hello/Ankur
    @GetMapping("/hello/{name}")
    public String sayHelloPath(@PathVariable String name) {
        return "Hello " + name;
    }
}