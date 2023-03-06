package com.digitazon.economicaircompany.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private String tourName;

    private String description;

    private String picture;

    @Column
    private Double tourPrice;

    public Tour() {
    }

    public Tour(String code, String tourName, String description, String picture, Double tourPrice) {
        this.code = code;
        this.tourName = tourName;
        this.description = description;
        this.picture = picture;
        this.tourPrice = tourPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Double getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(Double tourPrice) {
        this.tourPrice = tourPrice;
    }




        
}
