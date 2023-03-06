package com.digitazon.economicaircompany.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.digitazon.economicaircompany.model.BookingNew;
import com.digitazon.economicaircompany.repository.BookingRepositoryNew;
import com.digitazon.economicaircompany.repository.TourRepository;

@Service
public class BookingServiceNew {

    @Autowired
    BookingRepositoryNew bookingRepositorynew;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    FlightServiceNew flightServicenew; 

    @Autowired
    TourService tourService; 

    

    public List<BookingNew> getAllBookings() {

        return bookingRepositorynew.findAll(); 
    }

    

    public BookingNew getBookingNewByID(Long id) {

        Optional<BookingNew> bookingOpt = bookingRepositorynew.findById(id);

        //return bookingOpt.get();
        return bookingOpt.orElse(null);
    }

    public BookingNew createBooking(BookingNew booking) {

        /** Attivando il CASCADE per la creazione, non mi servirebbe questo controllo manuale */
        if(booking.getFlightNew() != null && booking.getFlightNew().getId() != null){
        
           
           //Se dalla richiesta esterna mi arriva un flight con un ID, vuol dire che non lo devo creare peché è già presente a DB. 
            flightServicenew.createFlight(booking.getFlightNew()); 
        }


        return bookingRepositorynew.save(booking);

    }

    public BookingNew createBookingTour(BookingNew bookingt) {
      
        /** Attivando il CASCADE per la creazione, non mi servirebbe questo controllo manuale */
        if(bookingt.getTour() != null && bookingt.getTour().getId() != null){
        
           
           //Se dalla richiesta esterna mi arriva un flight con un ID, vuol dire che non lo devo creare peché è già presente a DB. 
            tourService.createTour(bookingt.getTour()); 
        }


        return bookingRepositorynew.save(bookingt);

    }



        /** Attivando il CASCADE per la creazione, non mi servirebbe questo controllo manuale */
        //if(booking.getFlightNew() != null && booking.getFlightNew().getId() != null){
        
           
           //Se dalla richiesta esterna mi arriva un flight con un ID, vuol dire che non lo devo creare peché è già presente a DB. 
            //flightServicenew.createFlight(booking.getFlightNew()); 

            /* 
            @PostMapping("/create")
    public ResponseEntity<BookingNew> createBooking(@RequestBody BookingNew booking) {

        BookingNew savedBooking = bookingRepositorynew.save(booking);

        return new ResponseEntity<BookingNew>(savedBooking, HttpStatus.OK);*/
    }







   /*




   
    public void deleteBooking(Long id) {

        bookingRepository.deleteById(id);

    }


    public Booking findById(long id) {
        return null;
    }

    public Booking updateBooking(Booking newBooking) {

        Booking oldBooking = getBookingByID(newBooking.getId());

        if (oldBooking != null) {

            oldBooking.setCode(newBooking.getCode());
            oldBooking.setDescription(newBooking.getDescription());
            oldBooking.setSeatNumber(newBooking.getSeatNumber());
            oldBooking.setTicketPrice(newBooking.getTicketPrice());
            oldBooking.setFlight(newBooking.getFlight());

            return bookingRepository.save(oldBooking);
        } else
            return null; 
    }

} */


//NUOVO CODICE CHE NON FUNZIONA
/* 
public BookingNew createBooking(BookingNew bookingnew) {
    if(bookingnew.getFlightNew() != null && bookingnew.getFlightNew().getId() != null){
      // If the flight is already present in the database, use its ID
      bookingnew.setFlightNew(flightServicenew.getFlightNewByID(bookingnew.getFlightNew().getId()).orElse(null));
    } else {
      // Otherwise, create a new flight and use its ID
      bookingnew.setFlightNew(flightServicenew.createFlight(bookingnew.getFlightNew()));
    }
    return bookingRepositorynew.save(bookingnew);
  }  }
  */