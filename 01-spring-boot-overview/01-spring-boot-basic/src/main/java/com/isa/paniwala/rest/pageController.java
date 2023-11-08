package com.isa.paniwala.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pageController {

    @GetMapping("/")
    public String HelloWorld() {
        return "Hello World";
    }
}
