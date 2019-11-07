package com.evuazeze.restaurantreviews.service;

import com.evuazeze.restaurantreviews.model.Review;

import java.util.List;

public interface ReviewService {
    void saveReview(Review review);

    List<Review> listReviews();

    Review findReview(Long id);

    List<Review> listRestaurantReviews(Long id);

    void updateReview(Long id, Review reviewUpdate);

    void deleteReview(Long id);
}
