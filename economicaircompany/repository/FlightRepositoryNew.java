package com.digitazon.economicaircompany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.economicaircompany.model.FlightNew;

/* Long rappresenta il tipo della chiave primaria espressa nel model. 
Non posso avere tipi primitivi ma solo classi Wrapper, se fosse stata Integer allora qui 
avrei avuto Integer */
public interface FlightRepositoryNew extends JpaRepository<FlightNew, Long> {
    
    List<FlightNew> findByDepAirportAndArrAirportOrderByTicketPriceAsc(String depAirport, String arrAirport);

}


