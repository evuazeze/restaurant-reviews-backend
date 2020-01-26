//package com.evuazeze.restaurantreviews.controller;
//
//import com.evuazeze.restaurantreviews.model.Cordinates;
//import com.evuazeze.restaurantreviews.model.OperatingHours;
//import com.evuazeze.restaurantreviews.model.Restaurant;
//import com.evuazeze.restaurantreviews.service.RestaurantService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.RestDocumentationContextProvider;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.util.Optional;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
//import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//@AutoConfigureRestDocs(outputDir = "target/generated-docs")
//public class RestaurantControllerTest {
//    @MockBean
//    private RestaurantService restaurantService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private Restaurant mockRestaurant;
//
//    @BeforeEach
//    public void setUp(/*WebApplicationContext webApplicationContext,
//                      RestDocumentationContextProvider restDocumentation*/) {
//
////        this.mockMvc = MockMvcBuilders
////                .webAppContextSetup(webApplicationContext)
////                .apply(documentationConfiguration(restDocumentation))
////                .build();
//
//        Cordinates cordinates = new Cordinates();
//        cordinates.setId(1L);
//        cordinates.setLat(1.00);
//        cordinates.setLng(1.00);
//
//        OperatingHours operatingHours = new OperatingHours();
//        operatingHours.setId(1L);
//        operatingHours.setMonday("8.00 AM - 9.00 AM");
//        operatingHours.setTuesday("9.00 AM - 10.00 AM");
//        operatingHours.setWednesday("10.00 AM - 11.00 AM");
//        operatingHours.setThursday("12.00 PM - 1.00 PM");
//        operatingHours.setFriday("2.00 PM - 3.00 PM");
//        operatingHours.setSaturday("4.00 PM - 5.00 PM");
//        operatingHours.setSunday("6.00 PM - 7.00 PM");
//
//        mockRestaurant = new Restaurant();
//        mockRestaurant.setId(1L);
//        mockRestaurant.setName("Restaurant Name");
//        mockRestaurant.setCuisineType("Cuisine Type");
//        mockRestaurant.setAddress("Address");
//        mockRestaurant.setNeighborhood("Neighborhood");
//        mockRestaurant.setPhotograph("Photograph");
//        mockRestaurant.setCordinates(cordinates);
//        mockRestaurant.setOperatingHours(operatingHours);
//        mockRestaurant.setIsFavorite(true);
//
//    }
//
//    @Test
//    @DisplayName("GET /api/v1/restaurants")
//    void testGetRestaurants() {
//
//    }
//
//    @Test
//    @DisplayName("GET /api/v1/restaurants/{id} - Found")
//    void testGetRestaurantByIdFound() throws Exception {
//        // Setup mock service
//        String restaurantJson = new ObjectMapper().writeValueAsString(mockRestaurant);
//        doReturn(Optional.of(mockRestaurant)).when(restaurantService).findById(1L);
//
//        // Execute the GET request
//        mockMvc.perform(get("/api/v1/restaurants/{id}", 1))
//                // Validate the response code and content type
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
////                .andDo(print())
//
//                // Validate the headers
//                .andExpect(header().string(HttpHeaders.LOCATION, "/api/v1/restaurants/1"))
//
//                // Validate the returned fields
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.name").value("Restaurant Name"))
//
//                .andExpect(MockMvcResultMatchers.content().json(restaurantJson))
//
//                .andDo(document("/get-restaurant-by-id",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint())));
//
////                .andDo(document("/restaurants", responseFields(fieldWithPath("id").description("The restaurant's Id"),
////                        fieldWithPath("name").description("The restaurant's name"),
////                        fieldWithPath("neighborhood").description("The restaurant's neighborhood"),
////                        fieldWithPath("photograph").description("The restaurant's photo"),
////                        fieldWithPath("address").description("The restaurant's address"),
////                        fieldWithPath("neighborhood").description("The restaurant's neighborhood"),
////                        fieldWithPath("latlng").description("The restaurant's cordinates"),
////                        fieldWithPath("cuisine_type").description("The restaurant's served cuisine"),
////                        fieldWithPath("operating_hours").description("The restaurant's opening hours"),
////                        fieldWithPath("is_favorite").description("The restaurant's like status"),
////                        fieldWithPath("created_at").description("Date created"),
////                        fieldWithPath("updated_at").description("Date updated"))));
//    }
//
//    @Test
//    @DisplayName("GET /api/v1/restaurants/{id} - Not Found")
//    void testGetRestaurantByIdNotFound() throws Exception {
//        // Setup mocked service
//        doReturn(Optional.empty()).when(restaurantService).findById(1L);
//
//        // Execute the GET request
//        mockMvc.perform(get("/api/v1/restaurants/{id}", 1))
//
//                // Validate that we get a 404 Not Found response
//                .andExpect(status().isNotFound());
//    }
//
//    @Test
//    @DisplayName("POST /api/v1/restaurants - Success")
//    void testCreateRestaurant() throws Exception {
//        // Setup mocked service
//        String restaurantJson = new ObjectMapper().writeValueAsString(mockRestaurant);
//
//        Cordinates cordinates = new Cordinates();
//        cordinates.setId(1L);
//        cordinates.setLat(1.00);
//        cordinates.setLng(1.00);
//
//        OperatingHours operatingHours = new OperatingHours();
//        operatingHours.setId(1L);
//        operatingHours.setMonday("8.00 AM - 9.00 AM");
//        operatingHours.setTuesday("9.00 AM - 10.00 AM");
//        operatingHours.setWednesday("10.00 AM - 11.00 AM");
//        operatingHours.setThursday("12.00 PM - 1.00 PM");
//        operatingHours.setFriday("2.00 PM - 3.00 PM");
//        operatingHours.setSaturday("4.00 PM - 5.00 PM");
//        operatingHours.setSunday("6.00 PM - 7.00 PM");
//
//        Restaurant postRestaurant = new Restaurant();
//        postRestaurant.setName("Restaurant Name");
//        postRestaurant.setCuisineType("Cuisine Type");
//        postRestaurant.setAddress("Address");
//        postRestaurant.setNeighborhood("Neighborhood");
//        postRestaurant.setPhotograph("Photograph");
//        postRestaurant.setCordinates(cordinates);
//        postRestaurant.setOperatingHours(operatingHours);
//        postRestaurant.setIsFavorite(true);
////        Restaurant mockRestaurant = new Restaurant(1L, "Restaurant Name");
//        doReturn(mockRestaurant).when(restaurantService).save(any());
//
//        mockMvc.perform(post("/api/v1/restaurants")
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(asJsonString(postRestaurant)))
//
//                // Validate the response code and content type
//                .andExpect(status().isCreated())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
//                // Validate the headers
//                .andExpect(header().string(HttpHeaders.LOCATION, "/api/v1/restaurants/1"))
//
//                // Validate the returned fields
//                .andExpect(MockMvcResultMatchers.content().json(restaurantJson))
//
//                .andDo(document("/post-restaurant",
//                preprocessRequest(prettyPrint()),
//                preprocessResponse(prettyPrint())));
//
//
////                .andExpect(jsonPath("$.id").value(1L))
////                .andExpect(jsonPath("$.name").value("Restaurant Name"));
//    }
//
//    static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
