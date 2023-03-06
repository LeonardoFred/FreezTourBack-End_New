package com.digitazon.economicaircompany.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitazon.economicaircompany.model.Booking;
import com.digitazon.economicaircompany.service.BookingService;

@RestController
@CrossOrigin
@RequestMapping("/api/booking")
public class BookingRestController {

    @Autowired
    private BookingService bookingService;


    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {

        List<Booking> bookings = bookingService.getAllBookings();

        return new ResponseEntity<List<Booking>>(bookings, HttpStatus.OK);

    }
   
    @GetMapping("/{id}")
	public ResponseEntity<Booking> getBookingByID(@PathVariable long id) {
		Booking rest = bookingService.getBookingByID(id);

		return new ResponseEntity<>(rest, rest == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}



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

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {

        return new ResponseEntity<Booking>(bookingService.createBooking(booking), HttpStatus.OK);

    }

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
