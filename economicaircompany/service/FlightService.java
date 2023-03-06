package com.digitazon.economicaircompany.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.economicaircompany.model.Flight;
import com.digitazon.economicaircompany.repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirportService airportService; 

    public List<Flight> getAllFlights() {

        return flightRepository.findAll(); 
    }

    public Flight getFlightByID(Long id) {

        Optional<Flight> flightOpt = flightRepository.findById(id);

        return flightOpt.get();
    }

    public Flight createFlight(Flight flight) {

        //Se ho un aeroporto valorizzato nella richiesta
        if(flight.getArrAirport() != null){
            airportService.createAirport(flight.getArrAirport()); 
        }

        if(flight.getDepAirport()!= null){
            airportService.createAirport(flight.getDepAirport()); 
        }

        return flightRepository.save(flight);

    }

    /*
     * Potrebbe essere una buona idea inserire questi controlli in un metodo 
     * privato dentro classe Service in modo che siano uguali sempre
     * 
     * TODO: Controllo su aeroporto di destinazione diverso da arrivo 
     * TODO: Controllo su orari (timestamp di partenza < timestamp di arrivo )
     * TODO: Controllo se aeroporti sono diversi da null
     */
    public Flight updateFlight(Flight newFlight) {

        Flight oldFlight = getFlightByID(newFlight.getId());

        if (oldFlight != null) {

            oldFlight.setArrAirport(newFlight.getArrAirport());
            oldFlight.setDepAirport(newFlight.getDepAirport());
            oldFlight.setTimeArr(newFlight.getTimeArr());
            oldFlight.setTimeDep(newFlight.getTimeDep());

            // Nota, sto passando anche l'ID a differenza del salvataggio
            return flightRepository.save(oldFlight);
        } else
            return null; // TODO: gestire con una exception
    }

    public void deleteFlight(Long id) {

        flightRepository.deleteById(id);

    }
}
