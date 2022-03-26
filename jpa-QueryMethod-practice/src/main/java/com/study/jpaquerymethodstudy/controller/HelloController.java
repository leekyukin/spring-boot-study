package com.study.jpaquerymethodstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello! fuck you";
    }

    @GetMapping("/name/{name}")
    public String name(
            @PathVariable String name
    ) {
        return name;
    }
}
