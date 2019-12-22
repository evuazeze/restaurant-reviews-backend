package com.evuazeze.restaurantreviews.service;

import com.evuazeze.restaurantreviews.exception.RestaurantNotFoundException;
import com.evuazeze.restaurantreviews.model.Restaurant;
import com.evuazeze.restaurantreviews.repository.RestaurantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RestaurantServiceTest {
    @Autowired
    private RestaurantService restaurantService;

    @MockBean
    private RestaurantRepository restaurantRepository;

    @Test
    @DisplayName("Test findById Success")
    void testFindByIdSuccess() {
        // Setup our mock
        Restaurant mockRestaurant = new Restaurant(1L, "Restaurant Name");
        doReturn(Optional.of(mockRestaurant)).when(restaurantRepository).findById(1L);

        // Execute the service call
        Optional<Restaurant> returnedRestaurant = restaurantService.findById(1L);

        // Assert the response
        assertAll(() -> assertThat(returnedRestaurant.isPresent()).withFailMessage("Restaurant was not found").isEqualTo(true),
                () -> assertThat(returnedRestaurant.get()).withFailMessage("Restaurant should be the same").isEqualTo(mockRestaurant));
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock
        doReturn(Optional.empty()).when(restaurantRepository).findById(1L);

        // Assert the response
        Assertions.assertThrows(RestaurantNotFoundException.class, () -> restaurantService.findById(1L), "RestaurantNotFoundException should be thrown");

    }

    @Test
    @DisplayName("Test findAll")
    void testFindAll() {
        // Setup our mock
        Restaurant mockRestaurant = new Restaurant(1L, "Restaurant Name");
        Restaurant mockRestaurant2 = new Restaurant(2L, "Restaurant Name 2");
        doReturn(Arrays.asList(mockRestaurant, mockRestaurant2)).when(restaurantRepository).findAll();

        // Execute the service call
        List<Restaurant> restaurants = restaurantService.findAll();

        Assertions.assertEquals(2, restaurants.size(), "findAll should return 2 restaurants");
    }

    @Test
    @DisplayName("Test save restaurant")
    void testSave() {
        Restaurant mockRestaurant = new Restaurant(1L, "Restaurant Name");
        doReturn(mockRestaurant).when(restaurantRepository).save(any());

        Restaurant returnedRestaurant = restaurantService.save(mockRestaurant);

        assertAll(() -> assertThat(returnedRestaurant).withFailMessage("The saved product should not be null").isNotNull(),
                () -> assertThat(returnedRestaurant.getName()).withFailMessage("The name of the restaurant should be Restaurant Name").isEqualTo("Restaurant Name"));
    }
}
