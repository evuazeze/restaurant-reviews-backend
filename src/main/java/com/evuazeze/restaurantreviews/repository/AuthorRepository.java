package com.evuazeze.restaurantreviews.repository;

import com.evuazeze.restaurantreviews.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
