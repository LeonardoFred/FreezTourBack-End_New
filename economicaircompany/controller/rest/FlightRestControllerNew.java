package com.digitazon.economicaircompany.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.economicaircompany.model.FlightNew;
import com.digitazon.economicaircompany.service.FlightServiceNew;

@RestController
@CrossOrigin
@RequestMapping("/api/flightnew")
public class FlightRestControllerNew {

    @Autowired
    private FlightServiceNew flightServicenew;

    @GetMapping("/all")
    public ResponseEntity<List<FlightNew>> getAllFlights() {

        List<FlightNew> flights = flightServicenew.getAllFlights();

        return new ResponseEntity<List<FlightNew>>(flights, HttpStatus.OK);

    }

    @GetMapping("/{id}")
	public ResponseEntity<FlightNew>  getFlightNewByID(@PathVariable long id) {
		FlightNew fn = flightServicenew.getFlightNewByID(id);

		return new ResponseEntity<>(fn,fn == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

    @GetMapping
    public List<FlightNew> getFlightsByDepAndArrAirports(@RequestParam String depAirport, @RequestParam String arrAirport) {
        return flightServicenew.findFlightsByDepAndArrAirports(depAirport, arrAirport);
    
    }
    

    @PostMapping("/create")
    public ResponseEntity<FlightNew> createFlight(@RequestBody FlightNew flight) {

        return new ResponseEntity<FlightNew>(flightServicenew.createFlight(flight), HttpStatus.OK);

    }
}
    
    /* 

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


    } 
        
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
            return title1;

        }   */
        


    




