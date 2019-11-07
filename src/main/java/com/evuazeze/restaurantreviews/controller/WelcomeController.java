package com.evuazeze.restaurantreviews.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class WelcomeController {
    @GetMapping
    public void welcome() {
        System.out.println("Welcome to Restaurant Reviews App");
    }
}
