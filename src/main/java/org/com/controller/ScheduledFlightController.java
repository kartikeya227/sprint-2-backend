package org.com.controller;

import oracle.sql.DATE;
import org.com.dao.ScheduledFlightDao;
import org.com.error.RecordNotFoundException;
import org.com.model.airport;
import org.com.model.flight;
import org.com.model.scheduledFlight;
import org.com.model.scheduledFlightSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/scheduled")
@CrossOrigin(origins = "http://localhost:4200")

public class ScheduledFlightController {
    @Autowired
    private ScheduledFlightDao scheduledFlightDao;

    @GetMapping("/flight")
    public List<scheduledFlight> viewAllScheduledFlight() {
        return scheduledFlightDao.viewScheduledFlights();
    }

    @GetMapping("/flight/{id}")
    public List<scheduledFlight> viewAllScheduledFlight(@PathVariable("id") int flightNumber) {
        return scheduledFlightDao.viewScheduledFlights(flightNumber);
    }

    @GetMapping("/flight/{id1}/{id2}/{id3}/{id4}")
    public List<scheduledFlight> viewAllScheduledFlight
            (@PathVariable("id1") String sourceAirportCode,
             @PathVariable("id2") String destinationAirportCode,
             @PathVariable("id3") Date arrivalDate,
             @PathVariable("id4") Date departureDate) {
        return scheduledFlightDao.viewScheduledFlightsByAirportDate(sourceAirportCode,destinationAirportCode, arrivalDate,departureDate);
    }

    @PostMapping("/flight")
    public ResponseEntity<scheduledFlight> addScheduledFlight(@Valid @RequestBody scheduledFlight scheduledFlight) {
        try {
            scheduledFlightDao.addScheduleFlight(scheduledFlight);
            return new ResponseEntity<scheduledFlight>(scheduledFlight, HttpStatus.CREATED);
        }
        catch (RecordNotFoundException e){
            return new ResponseEntity(e,HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/flight/{id}")
    public ResponseEntity<scheduledFlight> deleteScheduledFlight(@PathVariable("id") int scheduleFlightId){
        Optional<scheduledFlight> findById= scheduledFlightDao.scheduledFlightExists(scheduleFlightId);
        try{
            if(findById.isPresent()){
                scheduledFlightDao.deleteScheduledFlight(scheduleFlightId);
                return new ResponseEntity(findById,HttpStatus.OK);
            }
            else{
                throw new RecordNotFoundException("No record with scheduled flight Id "+scheduleFlightId+" found.");
            }
        }
        catch(RecordNotFoundException e){
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/flight/{id}")
    public ResponseEntity<scheduledFlight> modifyScheduledFlight(@Valid @RequestBody scheduledFlight scheduledFlight, @PathVariable("id") int scheduleFlightId){
        Optional<scheduledFlight> findById= scheduledFlightDao.scheduledFlightExists(scheduleFlightId);
        try{
            if(findById.isPresent()){
                scheduledFlightDao.modifyScheduledFlight(scheduledFlight);
                return new ResponseEntity(scheduledFlight,HttpStatus.OK);
            }
            else{
                throw new RecordNotFoundException("No record with scheduled flight Id "+scheduleFlightId+" found.");
            }
        }
        catch(RecordNotFoundException e){
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }
}
