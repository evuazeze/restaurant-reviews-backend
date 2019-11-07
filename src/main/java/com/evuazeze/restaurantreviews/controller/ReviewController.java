package com.evuazeze.restaurantreviews.controller;

import com.evuazeze.restaurantreviews.exception.ReviewNotFoundException;
import com.evuazeze.restaurantreviews.model.Review;
import com.evuazeze.restaurantreviews.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createReview(@RequestBody Review review) {
        reviewService.saveReview(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        List<Review> list = reviewService.listReviews();
        return list;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Review>(reviewService.findReview(id), HttpStatus.OK);
        } catch (ReviewNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Not Found");
        }
    }

    @GetMapping("/")
    public @ResponseBody List<Review> getRestaurantReviews(@RequestParam("restaurant_id") Long id) {
        List<Review> restaurantReviews = reviewService.listRestaurantReviews(id);
        return restaurantReviews;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateReview(@PathVariable("id") Long id, @RequestBody Review reviewUpdate) {
        reviewService.updateReview(id, reviewUpdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
    }
}
