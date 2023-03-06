package com.digitazon.economicaircompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.economicaircompany.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
