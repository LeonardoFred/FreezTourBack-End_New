package com.digitazon.economicaircompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.economicaircompany.model.BookingNew;

public interface BookingRepositoryNew extends JpaRepository<BookingNew, Long> {
    
}
