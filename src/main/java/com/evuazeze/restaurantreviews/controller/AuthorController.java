package com.evuazeze.restaurantreviews.controller;

import com.evuazeze.restaurantreviews.model.Author;
import com.evuazeze.restaurantreviews.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public void createAuthor(@RequestBody Author author) {
        authorService.saveAuthor(author);
    }
}
