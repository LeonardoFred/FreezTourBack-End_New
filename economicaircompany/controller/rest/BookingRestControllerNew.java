package com.digitazon.economicaircompany.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.economicaircompany.model.BookingNew;
import com.digitazon.economicaircompany.model.FlightNew;
import com.digitazon.economicaircompany.model.Tour;
import com.digitazon.economicaircompany.service.BookingServiceNew;
import com.digitazon.economicaircompany.service.FlightServiceNew;
import com.digitazon.economicaircompany.service.TourService;


@RestController
@CrossOrigin
@RequestMapping("/api/bookingnew")
public class BookingRestControllerNew {

    @Autowired
    private BookingServiceNew bookingServicenew;
    
    @Autowired
    private FlightServiceNew flightServicenew;

    //add TourService
    @Autowired
    private TourService tourService;




    @GetMapping("/all")
    public ResponseEntity<List<BookingNew>> getAllBookings() {

        List<BookingNew> bookings = bookingServicenew.getAllBookings();

        return new ResponseEntity<List<BookingNew>>(bookings, HttpStatus.OK);

    }


    @PostMapping("/create")
    public ResponseEntity<BookingNew> createBooking(@RequestBody BookingNew booking) {
        FlightNew flightNew = booking.getFlightNew();
        if (flightNew != null && flightNew.getId() != null) {
            // If the flight is already present in the database, use its ID
            booking.setFlightNew(flightServicenew.getFlightNewByID(flightNew.getId()));
        } else {
            // Otherwise, create a new flight and use its ID
            booking.setFlightNew(flightServicenew.createFlight(flightNew));
        }

        

        BookingNew savedBooking = bookingServicenew.createBooking(booking);

        return new ResponseEntity<BookingNew>(savedBooking, HttpStatus.OK);
    }

    
    @PostMapping("/createtour")
    public ResponseEntity<BookingNew> createBookingTour(@RequestBody BookingNew booking) {
        //FlightNew flightNew = booking.getFlightNew();
        Tour tour = booking.getTour(); // Get the tour object from the booking
        //if (flightNew != null && flightNew.getId() != null) {
            // If the flight is already present in the database, use its ID
            //booking.setFlightNew(flightServicenew.getFlightNewByID(flightNew.getId()));
        //} else {
            // Otherwise, create a new flight and use its ID
        //    booking.setFlightNew(flightServicenew.createFlight(flightNew));
        //}
        
        if (tour != null && tour.getId() != null) {
            // If the tour is already present in the database, use its ID
            booking.setTour(tourService.getTourByID(tour.getId()));
        } else {
            // Otherwise, create a new tour and use its ID
            booking.setTour(tourService.createTour(tour));
        }
        
        BookingNew savedBooking = bookingServicenew.createBooking(booking);
        
        return new ResponseEntity<BookingNew>(savedBooking, HttpStatus.OK);
    } }







    /* 
    public ResponseEntity<BookingNew> createBookingTour(@RequestBody BookingNew bookingt) {
        Tour tour = bookingt.getTour();
        if (tour != null && tour.getId() != null) {
            // If the flight is already present in the database, use its ID
            bookingt.setTour(tourService.getTourByID(tour.getId()));
        } else {
            // Otherwise, create a new flight and use its ID
            bookingt.setTour(tourService.createTour(tour));
        }

        BookingNew savedBookingt = bookingServicenew.createBooking(bookingt);

        return new ResponseEntity<BookingNew>(savedBookingt, HttpStatus.OK);
    }}
*/




    /* VECCHIO POST MAPPING */
    

    //@PostMapping("/create")
   // public ResponseEntity<BookingNew> createBooking(@RequestBody BookingNew booking) {

        //return new ResponseEntity<BookingNew>(bookingServicenew.createBooking(booking), HttpStatus.OK);

    //} 

    
    


   /* 
    @GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingByID(@PathVariable long id) {
		Booking rest = bookingService.getBookingByID(id);

		return new ResponseEntity<>(rest, rest == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}
*/


    /* 
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingByID(@PathVariable Long id) {
        Booking booking = bookingService.getBookingByID(id);
        if (booking == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(booking);
        }
    }
*/


    /* 
    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBooking(@RequestBody Booking newBooking, @PathVariable long id) {

        return new ResponseEntity<Booking>(bookingService.updateBooking(newBooking), HttpStatus.OK);
    }
        

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteBooking(@PathVariable Long id) {

        bookingService.deleteBooking(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
*/