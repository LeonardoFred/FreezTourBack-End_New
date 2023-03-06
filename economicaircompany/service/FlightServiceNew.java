package com.digitazon.economicaircompany.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.economicaircompany.model.FlightNew;
import com.digitazon.economicaircompany.repository.FlightRepositoryNew;

@Service
public class FlightServiceNew {

    @Autowired
    FlightRepositoryNew flightRepositoryNew;



    public List<FlightNew> getAllFlights() {

        return flightRepositoryNew.findAll(); 
    }

    public FlightNew getFlightNewByID(Long id) {

        Optional<FlightNew> flightOpt = flightRepositoryNew.findById(id);

        return flightOpt.get();
    }


    public FlightNew createFlight(FlightNew flightNew) {

        /* 
        //Se ho un aeroporto valorizzato nella richiesta
        if(flight.getArrAirport() != null){
            airportService.createAirport(flight.getArrAirport()); 
        }

        if(flight.getDepAirport()!= null){
            airportService.createAirport(flight.getDepAirport()); 
        }*/

        return flightRepositoryNew.save(flightNew);

    }

    public List<FlightNew> findFlightsByDepAndArrAirports(String depAirport, String arrAirport) {
        return flightRepositoryNew.findByDepAirportAndArrAirportOrderByTicketPriceAsc(depAirport, arrAirport);
    }

    /*
     * Potrebbe essere una buona idea inserire questi controlli in un metodo 
     * privato dentro classe Service in modo che siano uguali sempre
     * 
     
    
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
            return null; //
    }

    public void deleteFlight(Long id) {

        flightRepository.deleteById(id);

    } */
}
