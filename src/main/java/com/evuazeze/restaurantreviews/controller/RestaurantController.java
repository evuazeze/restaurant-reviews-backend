package com.evuazeze.restaurantreviews.controller;

import com.evuazeze.restaurantreviews.exception.RestaurantNotFoundException;
import com.evuazeze.restaurantreviews.model.Restaurant;
import com.evuazeze.restaurantreviews.service.RestaurantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> list = restaurantService.listRestaurants();
        return list;
    }

    @GetMapping("/restaurants/")
    public @ResponseBody List<Restaurant> getFavouriteRestaurants(@RequestParam("is_favorite") boolean value) {
        List<Restaurant> favoriteRestaurants = restaurantService.listFavouriteRestaurants(value);
        return favoriteRestaurants;
    }

    @PostMapping("/restaurants")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
    }

    @GetMapping("/restaurants/{id}")
    @ApiOperation(value = "Finds Restaurants by id",
    notes = "Provide an id to look up a specific restaurant",
    response = Restaurant.class)
    public ResponseEntity<Restaurant> getRestaurant(@ApiParam(value = "ID value for the restaurant you need to retrieve", required = true) @PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Restaurant>(restaurantService.findRestaurant(id), HttpStatus.OK);
        } catch (RestaurantNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant Not Found");
        }
    }

    @PutMapping("/restaurants/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void favoriteARestaurant(@PathVariable("id") Long id, @RequestParam("is_favorite") Boolean value) {
        restaurantService.favoriteARestaurant(id, value);
    }
}
