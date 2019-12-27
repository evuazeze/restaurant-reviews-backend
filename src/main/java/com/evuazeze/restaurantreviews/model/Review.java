package com.evuazeze.restaurantreviews.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review extends TimeStamp {

    @Id
    @TableGenerator(name="TABLE_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
            valueColumnName="SEQ_COUNT", pkColumnValue="REV_SEQ")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
    private Long id;

    @ManyToOne
    private Restaurant restaurant;

//    @ManyToOne
//    private Author author;

    private String name;
    private Integer rating;
    private String comments;

    @JsonProperty("restaurant_id")
    private void unpackRestaurantId(Long restaurant_id) {
        this.restaurant = new Restaurant();
        restaurant.setId(restaurant_id);
    }

//    @JsonProperty("author_id")
//    private void unpackAuthorId(Long author_id) {
//        this.author = new Author();
//        author.setId(author_id);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
