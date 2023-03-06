package com.digitazon.economicaircompany.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.economicaircompany.model.Airport;
import com.digitazon.economicaircompany.repository.AirportRepository;

@Service
public class AirportService {

    @Autowired
    AirportRepository airportRepository;

    public List<Airport> getAllAirports() {

        return airportRepository.findAll(); 
    }

    /* Qui posso chiamare il metodo anche getByPippoPluto */
    public Airport getAirportByID(Long id) {

        /*
         * IL findByID potrebbe non tornare nessun risultato quindi utilizziamo
         * una classe che è come se fosse un Wrapper
         */
        Optional<Airport> airportOpt = airportRepository.findById(id); // Ricorda, è un generic

        return airportOpt.get(); // Nota, dovremmo gestire il caso in cui abbiamo null con una eccezione

    }

    public Airport createAirport(Airport airport) {

        return airportRepository.save(airport);

    }

    public Airport updateAirport(Airport newAirport) {

        Airport oldAirport = getAirportByID(newAirport.getId());

        if (oldAirport != null) {

            oldAirport.setCity(newAirport.getCity());
            oldAirport.setCode(newAirport.getCode());
            oldAirport.setName(newAirport.getName());
            oldAirport.setNation(newAirport.getNation());

            // Nota, sto passando anche l'ID a differenza del salvataggio
            return airportRepository.save(oldAirport);
        } else
            return null; 
    }

    public void deleteAirport(Long id) {

        airportRepository.deleteById(id);

    }
}
