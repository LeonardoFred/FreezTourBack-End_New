package com.digitazon.economicaircompany.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.economicaircompany.model.Flight;

import com.digitazon.economicaircompany.service.FlightService;

@RestController
@RequestMapping("/api/flight")
public class FlightRestController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAllFlights() {

        List<Flight> flights = flightService.getAllFlights();

        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {

        return new ResponseEntity<Flight>(flightService.createFlight(flight), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight newFlight, @PathVariable long id) {

        return new ResponseEntity<Flight>(flightService.updateFlight(newFlight), HttpStatus.OK);
    }
        

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id) {

        flightService.deleteFlight(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
    /*@RequestMapping(value="time", method = {RequestMethod.GET,  RequestMethod.POST})
    public String flights(@RequestParam String name, Model model){
        String greeting = "Hello " + name + "!";
        model.addAttribute("greeting", greeting); 
        return greeting;


    } */  
        
        @GetMapping("/time")
        public String flights (Model model){
            String greeting = "Hello Boostrap 4ever!";
            model.addAttribute("greeting", greeting); 
            return greeting;

        }  
        
        /*@GetMapping("/time")
        public String title1 (Model title){
            String title1 = "Boostrap bye bye!";
            title.addAttribute("title1", title1); 
            return title1;*/

        }  
        


    




