package com.evuazeze.restaurantreviews.repository;

import com.evuazeze.restaurantreviews.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findRestaurantsByIsFavoriteIs(Boolean value);

    List<Restaurant> findAllByOrderByIdAsc();
}
