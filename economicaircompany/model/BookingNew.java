package com.digitazon.economicaircompany.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BookingNew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;


    @ManyToOne
    private FlightNew flightNew;

    @ManyToOne
    private Tour tour;

    public BookingNew() {
    }


    public BookingNew(String name, String surname, String email, FlightNew flightNew, Tour tour) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.flightNew = flightNew;
        this.tour=tour;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }


    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public FlightNew getFlightNew() {
        return flightNew;
    }


    public void setFlightNew(FlightNew flightNew) {
        this.flightNew = flightNew;
    }


    public Tour getTour() {
        return tour;
    }


    public void setTour(Tour tour) {
        this.tour = tour;
    }

    

}
