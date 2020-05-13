package org.com.controller;

import org.com.error.RecordNotFoundException;

import org.com.model.flight;
import org.com.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<flight> viewAllFlight() {
        return flightService.viewFlight();
    }

    @GetMapping("/flights/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<flight> findFlightById(@PathVariable("id") int flightId) {
        Optional<flight> findById = flightService.viewFlight(flightId);
        try {
            if (findById.isPresent()) {
                flight flight = findById.get();
                return new ResponseEntity<flight>(flight, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No record found with the provided " + flightId + "Flight Id.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/flights")
    public ResponseEntity<flight> addFlight(@Valid @RequestBody flight flight) {
        try {
            flightService.addFlight(flight);
            return new ResponseEntity(flight, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.IM_USED);
        }
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<flight> modifyFlight(@Valid @RequestBody flight flight, @PathVariable("id") int flightNumber) {
        Optional<flight> findById = flightService.viewFlight(flightNumber);
        try {
            if (findById.isPresent()) {
                flightService.modifyFlight(flight);
                return new ResponseEntity<flight>(flight, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No record with flight number " + flightNumber + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<flight> deleteFlight(@PathVariable("id") int flightNumber) {
        Optional<flight> findById = flightService.viewFlight(flightNumber);
        try {
            if (findById.isPresent()) {
                flightService.deleteFlight(flightNumber);
                return new ResponseEntity(findById, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No record with flight number " + flightNumber + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

}
