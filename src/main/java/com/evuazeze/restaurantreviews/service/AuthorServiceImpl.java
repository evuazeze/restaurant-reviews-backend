package com.evuazeze.restaurantreviews.service;

import com.evuazeze.restaurantreviews.model.Author;
import com.evuazeze.restaurantreviews.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }
}
