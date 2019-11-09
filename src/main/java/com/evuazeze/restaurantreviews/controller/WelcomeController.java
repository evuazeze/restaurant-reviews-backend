package com.evuazeze.restaurantreviews.controller;

import io.swagger.models.Path;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("")
public class WelcomeController {
    @GetMapping
    public String welcome(HttpServletRequest request) {
        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .build()
                .toUriString();

        return "Welcome to The Restaurant Reviews App, doc: " + baseUrl + "swagger-ui.html";
    }
}
