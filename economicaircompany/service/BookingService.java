package com.digitazon.economicaircompany.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.economicaircompany.model.Booking;
import com.digitazon.economicaircompany.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    FlightService flightService; 

    public List<Booking> getAllBookings() {

        return bookingRepository.findAll(); 
    }

    

    public Booking getBookingByID(Long id) {

        Optional<Booking> bookingOpt = bookingRepository.findById(id);

        //return bookingOpt.get();
        return bookingOpt.orElse(null);
    }

    public Booking createBooking(Booking booking) {

        /** Attivando il CASCADE per la creazione, non mi servirebbe questo controllo manuale */
        if(booking.getFlight() != null && booking.getFlight().getId() != null){
        
           
           //Se dalla richiesta esterna mi arriva un flight con un ID, vuol dire che non lo devo creare peché è già presente a DB. 
            flightService.createFlight(booking.getFlight()); 
        }


        return bookingRepository.save(booking);

    }

   

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

}
