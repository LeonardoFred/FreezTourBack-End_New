package com.digitazon.economicaircompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.economicaircompany.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>{
    
}
