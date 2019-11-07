package com.evuazeze.restaurantreviews.repository;

import com.evuazeze.restaurantreviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review r where r.restaurant.id = :id")
    List<Review> findReviewsByRestaurantId(@Param("id") Long id);
}
