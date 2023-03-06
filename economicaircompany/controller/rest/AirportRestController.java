package com.digitazon.economicaircompany.controller.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.economicaircompany.model.Airport;
import com.digitazon.economicaircompany.service.AirportService;



@RestController
@RequestMapping("/api/airport")
public class AirportRestController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/all")
    public ResponseEntity<List<Airport>> getAllAirport() {

        List<Airport> airports = airportService.getAllAirports();

        return new ResponseEntity<List<Airport>>(airports, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {

        return new ResponseEntity<Airport>(airportService.createAirport(airport), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Airport> updateAirport(@RequestBody Airport newAirport, @PathVariable long id) {

        return new ResponseEntity<Airport>(airportService.updateAirport(newAirport), HttpStatus.OK);
    }
        

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteAirport(@PathVariable Long id) {

        airportService.deleteAirport(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    
}
