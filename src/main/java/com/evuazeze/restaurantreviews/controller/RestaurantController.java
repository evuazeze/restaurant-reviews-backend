package com.evuazeze.restaurantreviews.controller;

import com.evuazeze.restaurantreviews.model.Restaurant;
import com.evuazeze.restaurantreviews.service.RestaurantService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {

    private static final Logger logger = LogManager.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public Iterable<Restaurant> getRestaurants() {
        Iterable<Restaurant> list = restaurantService.findAll();

//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:8887");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(list);

        return list;
    }

    @GetMapping("/restaurants/")
    public @ResponseBody
    List<Restaurant> getFavouriteRestaurants(@RequestParam("is_favorite") boolean value) {
        List<Restaurant> favoriteRestaurants = restaurantService.listFavouriteRestaurants(value);
        return favoriteRestaurants;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        logger.info("Creating new restaurant with name: {}, neighborhood: {}, cuisine type: {}", restaurant.getName(), restaurant.getNeighborhood(), restaurant.getCuisineType());

        Restaurant newRestaurant = restaurantService.save(restaurant);

        System.out.println(newRestaurant);

        return ResponseEntity
                .created(URI.create("/api/v1/restaurants/" + newRestaurant.getId()))
                .body(newRestaurant);
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") Long id) {

        return restaurantService.findById(id)
                .map(restaurant -> ResponseEntity
                        .ok()
                        .location(URI.create("/api/v1/restaurants/" + restaurant.getId()))
                        .body(restaurant))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/restaurants/{id}")
    public ResponseEntity<?> favoriteARestaurant(@PathVariable("id") Long id,
                                    @RequestParam("is_favorite") Boolean value) {
        logger.info("Liking/Unliking restaurant with id: {}", id);

        Optional<Restaurant> existingRestaurant = restaurantService.findById(id);

        return existingRestaurant.map(r -> {
            r.setIsFavorite(value);

            if (restaurantService.favoriteARestaurant(existingRestaurant.get())) {
                return ResponseEntity.ok()
                        .location(URI.create("/restaurants/" + r.getId()))
                        .body(existingRestaurant.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }).orElse(ResponseEntity.notFound().build());
    }
}
