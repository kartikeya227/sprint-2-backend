package org.com.controller;

import org.com.dao.FlightDao;
import org.com.error.RecordNotFoundException;
import org.com.model.airport;
import org.com.model.flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightDao flightDao;

    @GetMapping("/all")
    public List<flight> viewAllFlight(){
        return flightDao.viewFlight();
    }

    @GetMapping("/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<flight> findFlightById(@PathVariable("id") int flightId){
        Optional<flight> findById = flightDao.viewFlight(flightId);
        try {
            if (findById.isPresent()) {
                flight flight = findById.get();
                return new ResponseEntity<flight>(flight, HttpStatus.OK);
            }
            else {
                throw new RecordNotFoundException("No record found with the provided " + flightId + "Flight Id.");
            }
        }
        catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addFlight")
    public ResponseEntity<flight> addFlight(@Valid @RequestBody flight flight){
        flightDao.addFlight(flight);
        return new ResponseEntity("Flight is created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/modifyFlight/{id}")
    public ResponseEntity<flight> modifyFlight(@Valid @RequestBody flight flight, @PathVariable("id") int flightNumber){
        Optional<flight> findById= flightDao.viewFlight(flightNumber);
        try{
            if(findById.isPresent()){
                flightDao.modifyFlight(flight);
                return new ResponseEntity<flight>(flight,HttpStatus.OK);
            }
            else{
                throw new RecordNotFoundException("No record with flight number "+flightNumber+" found.");
            }
        }
        catch(RecordNotFoundException e){
                return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<flight> deleteFlight(@PathVariable("id") int flightNumber){
        Optional<flight> findById= flightDao.viewFlight(flightNumber);
        try{
            if(findById.isPresent()){
                flightDao.deleteFlight(flightNumber);
                return new ResponseEntity("Flight is deleted successfully",HttpStatus.OK);
            }
            else{
                throw new RecordNotFoundException("No record with flight number "+flightNumber+" found.");
            }
        }
        catch(RecordNotFoundException e){
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

}
