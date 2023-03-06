package com.digitazon.economicaircompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.digitazon.economicaircompany.model.Tour;


public interface TourRepository extends JpaRepository<Tour, Long> {
    
}


