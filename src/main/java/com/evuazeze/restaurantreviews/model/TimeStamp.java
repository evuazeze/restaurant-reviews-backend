package com.evuazeze.restaurantreviews.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
public class TimeStamp {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
//    @JsonProperty("created_at")
//    @Column(name = "created_at")
    private Date createdAt = new Date();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
//    @JsonProperty("updated_at")
//    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PreUpdate
    public final void setLastUpdate() {
        this.updatedAt = new Date();
    }
}
