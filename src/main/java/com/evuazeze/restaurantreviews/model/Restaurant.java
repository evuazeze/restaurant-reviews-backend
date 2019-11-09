package com.evuazeze.restaurantreviews.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
@ApiModel(description = "Details about the restaurant")
public class Restaurant extends TimeStamp {

    @Id
    @TableGenerator(name="TABLE_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
            valueColumnName="SEQ_COUNT", pkColumnValue="RES_SEQ")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
    @ApiModelProperty(notes = "The unique id of the restaurant")
    private Long id;

    @ApiModelProperty(notes = "The restaurant's name")
    private String name;
    @ApiModelProperty(notes = "The restaurant's neighborhood")
    private String neighborhood;
    @ApiModelProperty(notes = "The restaurant's photograph url")
    private String photograph;
    @ApiModelProperty(notes = "The restaurant's address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("latlng")
    @ApiModelProperty(notes = "The restaurant's location")
    private Cordinates cordinates;

    @Column(name = "cuisine_type")
    @JsonProperty("cuisine_type")
    @ApiModelProperty("Cuisine type offered")
    private String cuisineType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operating_hours_id")
    @JsonProperty("operating_hours")
    @ApiModelProperty(notes = "The restaurant's opening hours")
    private OperatingHours operatingHours;

    @Column(name = "is_favorite")
    @JsonProperty("is_favorite")
    @ApiModelProperty(notes = "like/unlike the restaurant")
    private boolean isFavorite;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (name == null || "".equals(name))
            throw new IllegalArgumentException("Invalid restaurant name");
        if (neighborhood == null || "".equals(neighborhood))
            throw new IllegalArgumentException("Invalid restaurant neighborhood");
        if (photograph == null || "".equals(photograph))
            throw new IllegalArgumentException("Invalid restaurant photograph");
        if (address == null || "".equals(address))
            throw new IllegalArgumentException("Invalid restaurant address");
        if (cuisineType == null || "".equals(cuisineType))
            throw new IllegalArgumentException("Invalid restaurant cuisine type");
        if (cordinates == null || cordinates.getLat() == null || cordinates.getLng() == null)
            throw new IllegalArgumentException("Invalid restaurant cordinates");
        if (operatingHours == null || operatingHours.getMonday() == null ||
            operatingHours.getTuesday() == null || operatingHours.getWednesday() == null ||
            operatingHours.getThursday() == null || operatingHours.getFriday() == null ||
            operatingHours.getSaturday() == null || operatingHours.getSunday() == null) {
            throw new IllegalArgumentException("Invalid restaurant operating hours");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cordinates getCordinates() {
        return cordinates;
    }

    public void setCordinates(Cordinates cordinates) {
        this.cordinates = cordinates;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisine_type) {
        this.cuisineType = cuisine_type;
    }

    public OperatingHours getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(OperatingHours operatingHours) {
        this.operatingHours = operatingHours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean is_favorite) {
        this.isFavorite = is_favorite;
    }
}
