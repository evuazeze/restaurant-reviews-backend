package com.evuazeze.restaurantreviews.service;

import com.evuazeze.restaurantreviews.exception.ReviewNotFoundException;
import com.evuazeze.restaurantreviews.model.Review;
import com.evuazeze.restaurantreviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> listReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);

        if (optionalReview.isPresent())
            return optionalReview.get();
        else
            throw new ReviewNotFoundException("Review Not Found");
    }

    @Override
    public List<Review> listRestaurantReviews(Long id) {
        return reviewRepository.findReviewsByRestaurantId(id);
    }

    @Override
    public void updateReview(Long id, Review reviewUpdate) {
        Review review = findReview(id);
        review.setRating(reviewUpdate.getRating());
        review.setComments(reviewUpdate.getComments());
        reviewRepository.saveAndFlush(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
