package com.digitazon.economicaircompany.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.economicaircompany.model.Tour;
import com.digitazon.economicaircompany.repository.TourRepository;

@Service
public class TourService {

    @Autowired
    TourRepository tourRepository;

    public List<Tour> getAllTour() {

        return tourRepository.findAll(); 
    }

    public Tour getTourByID(Long id) {

        Optional<Tour> tourOpt = tourRepository.findById(id);

        return tourOpt.get();
    }


    public Tour createTour(Tour tour) {

        return tourRepository.save(tour);

    }
}