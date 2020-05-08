package org.com.controller;

import org.com.dao.AirportDao;
import org.com.error.RecordNotFoundException;
import org.com.model.airport;
import java.util.Optional;

import org.com.model.flight;
import org.com.model.users;
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
public class AirportController {
    @Autowired
    private AirportDao airportDao;

        @GetMapping("/airport")
        public List<airport> viewAllAirport(){
            return airportDao.viewAirport();
        }

        @GetMapping("/airport/{id}")
        @ExceptionHandler(RecordNotFoundException.class)
        public ResponseEntity<airport> findAirportById(@PathVariable("id") String airportId){
            Optional<airport> findById = airportDao.viewAirport(airportId);
            try {
                    if (findById.isPresent()) {
                        airport airport = findById.get();
                        return new ResponseEntity<airport>(airport, HttpStatus.FOUND);
                    }
                    else {
                        throw new RecordNotFoundException("No record found with the provided " + airportId + "Airport code.");
                     }
              }
            catch (RecordNotFoundException e) {
                return new ResponseEntity("Airport Code Not found./n"+e.getMessage(),HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping("/airport")
        public ResponseEntity<airport> addAirport(@Valid @RequestBody airport airport){
            try{
                airportDao.addAirport(airport);
                return new ResponseEntity(airport, HttpStatus.CREATED);
            }
            catch (Exception e){
                return new ResponseEntity(e ,HttpStatus.IM_USED);
            }
        }

        @PutMapping("/airport/{id}")
        public ResponseEntity<airport> modifyAirport(@Valid @RequestBody airport airport, @PathVariable("id") String airportCode){
            Optional<airport> findById= airportDao.viewAirport(airportCode);
            try{
                if(findById.isPresent()){
                    airportDao.updateAirport(airport);
                    return new ResponseEntity<airport>(airport,HttpStatus.OK);
                }
                else{
                    throw new RecordNotFoundException("No record with flight number "+airportCode+" found.");
                }
            }
            catch(RecordNotFoundException e){
                return new ResponseEntity(e, HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/airport/{id}")
        public ResponseEntity<airport> deleteFlight(@PathVariable("id") String airportCode){
            Optional<airport> findById= airportDao.viewAirport(airportCode);
            try{
                if(findById.isPresent()){
                    airportDao.deleteAirport(airportCode);
                    return new ResponseEntity(findById,HttpStatus.OK);
                }
                else{
                    throw new RecordNotFoundException("No record with Airport Code "+airportCode+" found.");
                }
            }
            catch(RecordNotFoundException e){
                return new ResponseEntity(e, HttpStatus.NOT_FOUND);
            }
        }
}
