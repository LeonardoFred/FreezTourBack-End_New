package com.digitazon.economicaircompany.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class FlightNew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    @Column
    @Temporal(TemporalType.TIMESTAMP) // Se non passo valori, default data e ora istantanei
    private LocalDateTime timeDep;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timeArr;

   
    private String depAirport;


    private String arrAirport;

    @Column
    private Double ticketPrice;



    public FlightNew(String code, LocalDateTime timeDep, LocalDateTime timeArr, String depAirport, String arrAirport, Double ticketPrice) {
        this.code = code;
        this.timeDep = timeDep;
        this.timeArr = timeArr;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.ticketPrice = ticketPrice;
    }




    public FlightNew() {
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




    public LocalDateTime getTimeDep() {
        return timeDep;
    }




    public void setTimeDep(LocalDateTime timeDep) {
        this.timeDep = timeDep;
    }




    public LocalDateTime getTimeArr() {
        return timeArr;
    }




    public void setTimeArr(LocalDateTime timeArr) {
        this.timeArr = timeArr;
    }




    public String getDepAirport() {
        return depAirport;
    }




    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }




    public String getArrAirport() {
        return arrAirport;
    }



    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }




    public Double getTicketPrice() {
        return ticketPrice;
    }




    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }




    public FlightNew orElse(Object object) {
        return null;
    }


    

}
