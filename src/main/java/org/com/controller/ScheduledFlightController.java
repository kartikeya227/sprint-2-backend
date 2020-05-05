package org.com.controller;

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
@RequestMapping("/scheduledFlight")
public class ScheduledFlightController {
    @Autowired
    private ScheduledFlightDao scheduledFlightDao;

    @GetMapping("/all")
    public List<scheduledFlight> viewAllScheduledFlight() {
        return scheduledFlightDao.viewScheduledFlights();
    }

    @GetMapping("/{id}")
    public List<scheduledFlight> viewAllScheduledFlight(@PathVariable("id") int flightNumber) {
        return scheduledFlightDao.viewScheduledFlights(flightNumber);
    }

    @GetMapping("/searchByAirportAndDate")
    public List<scheduledFlight> searchScheduledFightByAirportAndDate(@Valid @RequestBody scheduledFlightSearch scheduledFlightSearch){
        System.out.println(scheduledFlightSearch.toString());
        return scheduledFlightDao.viewScheduledFlights(scheduledFlightSearch.getArrivalAirport(),scheduledFlightSearch.getDepartureAirport(),scheduledFlightSearch.getArrivalDate(),scheduledFlightSearch.getDepartureDate());
    }

    @PostMapping("/addScheduledFlight")
    public ResponseEntity<scheduledFlight> addScheduledFlight(@Valid @RequestBody scheduledFlight scheduledFlight) {
        try {
            scheduledFlightDao.addScheduleFlight(scheduledFlight);
            return new ResponseEntity("Flight has been scheduled successfully", HttpStatus.CREATED);
        }
        catch (RecordNotFoundException e){
            return new ResponseEntity("Check the provided data, either of provided (Airport, Schedule, Flight) may be invalid or unavailable at the moment",HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteScheduledFlight/{id}")
    public ResponseEntity<scheduledFlight> deleteScheduledFlight(@PathVariable("id") int scheduleFlightId){
        Optional<scheduledFlight> findById= scheduledFlightDao.scheduledFlightExists(scheduleFlightId);
        try{
            if(findById.isPresent()){
                scheduledFlightDao.deleteScheduledFlight(scheduleFlightId);
                return new ResponseEntity("Scheduled flight is deleted successfully",HttpStatus.OK);
            }
            else{
                throw new RecordNotFoundException("No record with scheduled flight Id "+scheduleFlightId+" found.");
            }
        }
        catch(RecordNotFoundException e){
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modifyScheduledFlight/{id}")
    public ResponseEntity<scheduledFlight> modifyScheduledFlight(@Valid @RequestBody scheduledFlight scheduledFlight, @PathVariable("id") int scheduleFlightId){
        Optional<scheduledFlight> findById= scheduledFlightDao.scheduledFlightExists(scheduleFlightId);
        try{
            if(findById.isPresent()){
                scheduledFlightDao.modifyScheduledFlight(scheduledFlight);
                return new ResponseEntity("Scheduled Flight is successfully updated.",HttpStatus.OK);
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
