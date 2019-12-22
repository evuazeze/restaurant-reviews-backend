package com.evuazeze.restaurantreviews.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("")
public class WelcomeController {
    @GetMapping
    public void welcome(HttpServletResponse httpResponse) {
        try {
            httpResponse.sendRedirect("/docs/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
