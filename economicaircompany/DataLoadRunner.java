package com.digitazon.economicaircompany;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.digitazon.economicaircompany.model.Airport;
import com.digitazon.economicaircompany.model.Booking;
import com.digitazon.economicaircompany.model.BookingNew;
import com.digitazon.economicaircompany.model.Flight;
import com.digitazon.economicaircompany.model.FlightNew;
import com.digitazon.economicaircompany.model.Tour;
import com.digitazon.economicaircompany.service.AirportService;
import com.digitazon.economicaircompany.service.BookingService;
import com.digitazon.economicaircompany.service.BookingServiceNew;
import com.digitazon.economicaircompany.service.FlightService;
import com.digitazon.economicaircompany.service.FlightServiceNew;
import com.digitazon.economicaircompany.service.TourService;




@Component
public class DataLoadRunner implements CommandLineRunner {

    /* Utilizzo i service! Non i repository */
    

    @Autowired
    FlightService flightService;

    @Autowired
    BookingService bookingService;      

    @Autowired
    BookingServiceNew bookingServicenew;

    @Autowired
    FlightServiceNew flightServiceNew;

    @Autowired
    AirportService airportService;

    @Autowired
    TourService tourService;

    @Override
    public void run(String... args) throws Exception {

        /** Dati di test da inserire nel database */
        
        Airport leonardoDaVinci = new Airport("Leonardo da Vinci", "Fiumicino", "Italy", "0001");

        Airport linate = new Airport("Linate", "Milano", "Italy", "0002");

        airportService.createAirport(leonardoDaVinci);
        airportService.createAirport(linate);

        Flight f1 = new Flight(LocalDateTime.of(2022, 12, 20, 11, 31),
                LocalDateTime.of(2022, 12, 20, 12, 31),
                leonardoDaVinci,
                linate);

        Flight f2 = new Flight(LocalDateTime.of(2022, 12, 21, 12, 30),
                LocalDateTime.of(2022, 12, 21, 14, 30),
                linate,
                leonardoDaVinci);

        FlightNew nf1 = new FlightNew("FZ-403", LocalDateTime.of(2023, 05, 21, 12, 30), LocalDateTime.of(2023, 05, 22, 14, 30), "New York", "Greenland", 1800.00); 
        FlightNew nf2 = new FlightNew("FZ-303", LocalDateTime.of(2023, 06, 12, 12, 30), LocalDateTime.of(2023, 06, 13, 14, 30), "Vancouver", "Greenland", 1400.00);  
        FlightNew nf3 = new FlightNew("FZ-503", LocalDateTime.of(2023, 06, 13, 12, 30), LocalDateTime.of(2023, 06, 14, 14, 30), "Copenhagen", "Iceland", 1300.00);  
        FlightNew nf4 = new FlightNew("FZ-404", LocalDateTime.of(2023, 05, 13, 12, 30), LocalDateTime.of(2023, 05, 14, 14, 30), "Stockholm", "Iceland", 1250.00);  
        FlightNew nf5 = new FlightNew("FZ-504", LocalDateTime.of(2023, 06, 14, 12, 30), LocalDateTime.of(2023, 06, 15, 14, 30), "Saint Petersburg", "Arkangelsk", 800.00); 
        FlightNew nf6 = new FlightNew("FZ-505", LocalDateTime.of(2023, 07, 14, 12, 30), LocalDateTime.of(2023, 07, 15, 14, 30), "Helsinky", "Greenland", 700.00);  
 
        
        // Creazione Tour 

        Tour tour1 = new Tour("TZ-401", "Greeland from 20-12 to 30-12-2023", "Greenland is like nowhere else in the world. In the winter, popular activities include dog sledding, ice fishing, and gazing speechless at the Northern Lights.","", 3000.00);
        Tour tour2 = new Tour("TZ-402", "Arctic from 20-12 to 30-12-2023", "Arcitc is like nowhere else in the world. In the winter, popular activities include dog sledding, ice fishing, and gazing speechless at the Northern Lights.","avatar", 3500.00);
        Tour tour3 = new Tour("TZ-403", "Antarctic from 20-12 to 30-12-2023", "Antarctic is like nowhere else in the world. In the winter, popular activities include dog sledding, ice fishing, and gazing speechless at the Northern Lights and Costs.","avatar", 3800.00);
        Tour tour4 = new Tour("TZ-404", "Icelad from 20-12 to 30-12-2023", "Iceland is like nowhere else in the world. In the winter, popular activities include dog sledding, ice fishing, and gazing speechless at the Northern Lights.","avatar", 3200.00);

        tourService.createTour(tour1);
        tourService.createTour(tour2);
        tourService.createTour(tour3);
        tourService.createTour(tour4);



        flightService.createFlight(f1);
        flightService.createFlight(f2);

        // New Flight
        flightServiceNew.createFlight(nf1);
        flightServiceNew.createFlight(nf2);
        flightServiceNew.createFlight(nf3);
        flightServiceNew.createFlight(nf4);
        flightServiceNew.createFlight(nf5);
        flightServiceNew.createFlight(nf6);

        
    
        //public Booking(String code, String seatNumber, String description, Double ticketPrice, Flight flight) 
        Booking b1 = new Booking("P001", "A01", "Posto finestrino", 9.99, f1); 
        Booking b2 = new Booking("P002", "G27", "Posto corridoio", 5.99, f1); 
        Booking b3 = new Booking("P003", "Z02", "Posto corridoio", 2.99, f1); 
        Booking b4 = new Booking("P004", "B31", "Posto in coda", 0.99, f2); 

        bookingService.createBooking(b1); 
        bookingService.createBooking(b2); 
        bookingService.createBooking(b3); 
        bookingService.createBooking(b4); 


        BookingNew bn1 = new BookingNew(null, null, null, nf1, null);
        BookingNew bn2 = new BookingNew("leo", "Fred", "email@gmail.com", nf2, null);
        bookingServicenew.createBooking(bn1); 
        bookingServicenew.createBooking(bn2); 
        /* Scrivere codice per testare anche DELETE, UPDATE e GET */

    }}

    


