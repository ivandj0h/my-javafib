package com.ivandjoh.javafib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @GetMapping
    public String getHome() {

        LOGGER.info("Hello, Welcome to my home!");

        return "Hello, Welcome to my home!";
    }
}
