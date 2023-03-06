package com.digitazon.economicaircompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.economicaircompany.model.Flight;

/* Long rappresenta il tipo della chiave primaria espressa nel model. 
Non posso avere tipi primitivi ma solo classi Wrapper, se fosse stata Integer allora qui 
avrei avuto Integer */
public interface FlightRepository extends JpaRepository<Flight, Long> {
    
}
