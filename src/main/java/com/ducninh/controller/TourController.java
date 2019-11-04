package com.ducninh.controller;

import com.ducninh.model.Tour;
import com.ducninh.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> findAllTour(){
        List<Tour> tours = (List<Tour>) tourService.findAll();
        if (tours.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tours, HttpStatus.OK);
    }

    @GetMapping("/tour/{id}")
    public ResponseEntity<Tour> findByIdTour(@PathVariable Long id){
        Tour tour = tourService.findById(id);
        if (tour == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @PostMapping("/tour")
    public ResponseEntity<Tour> createTour(@RequestBody Tour tour){
        tourService.save(tour);
        return new ResponseEntity<>(tour, HttpStatus.OK);
    }

    @PutMapping("/tour/{id}")
    public ResponseEntity<Tour> updateTour(@PathVariable Long id, @RequestBody Tour tour){
        Tour currentTour = tourService.findById(id);
        if (currentTour == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentTour.setTitleTour(tour.getTitleTour());
        currentTour.setIsDate(tour.getIsDate());
        currentTour.setContent(tour.getContent());
        currentTour.setPrice(tour.getPrice());
        currentTour.setTourPriceIncluded(tour.getTourPriceIncluded());
        currentTour.setTourPriceIsNotIncluded(tour.getTourPriceIsNotIncluded());
        currentTour.setTourPriceOfChildren(tour.getTourPriceOfChildren());
        currentTour.setSurcharge(tour.getSurcharge());

        tourService.save(currentTour);

        return new ResponseEntity<>(currentTour, HttpStatus.OK);

    }

    @DeleteMapping("/tour/{id}")
    public ResponseEntity<Tour> deleteTour(@PathVariable Long id){
        Tour tour = tourService.findById(id);
        if (tour == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tourService.remove(id);
        return new ResponseEntity<>(tour, HttpStatus.NO_CONTENT);
    }







}
