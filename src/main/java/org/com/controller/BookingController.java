package org.com.controller;

import org.com.error.RecordNotFoundException;
import org.com.model.booking;
import org.com.model.scheduledFlight;
import org.com.services.BookingService;
import org.com.services.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private ScheduledFlightService scheduledFlightService;

    @GetMapping("/bookings")
    public List<booking> viewAllBooking() {
        return bookingService.viewBooking();
    }

    @PostMapping("/bookings")
    public ResponseEntity<booking> addBooking(@Valid @RequestBody booking booking) {
        try {
            int noPassengers = booking.getNoOfPassengers();
            scheduledFlight currentScheduledFlight = booking.getScheduledFlight();
            currentScheduledFlight.setAvailableSeats(currentScheduledFlight.getAvailableSeats()-noPassengers);
            scheduledFlightService.modifyScheduledFlight(currentScheduledFlight);
            bookingService.addBooking(booking);
            return new ResponseEntity<booking>(booking, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.IM_USED);
        }
    }

    @GetMapping("bookings/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<booking> findBookingById(@PathVariable("id") int bookingId) {
        Optional<booking> findById = bookingService.viewBooking(bookingId);
        try {
            if (findById.isPresent()) {
                booking booking = findById.get();
                return new ResponseEntity<booking>(booking, HttpStatus.FOUND);
            } else {
                throw new RecordNotFoundException("No Booking record found with the provided " + bookingId + "Booking Id.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity("Booking Id Not found./n" + e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/bookings/{id}")
    public ResponseEntity<booking> modifyFlight(@Valid @RequestBody booking booking, @PathVariable("id") int bookingId) {
        Optional<booking> findById = bookingService.viewBooking(bookingId);
        try {
            if (findById.isPresent()) {
                bookingService.modifyBooking(booking);
                return new ResponseEntity<booking>(booking, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No booking with booking Id " + bookingId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<booking> deleteBooking(@PathVariable("id") int bookingId) {
        Optional<booking> findById = bookingService.viewBooking(bookingId);
        try {
            if (findById.isPresent()) {
                bookingService.deleteBooking(bookingId);
                return new ResponseEntity(findById, HttpStatus.OK);
            } else {
                throw new RecordNotFoundException("No Booking record with booking Id " + bookingId + " found.");
            }
        } catch (RecordNotFoundException e) {
            return new ResponseEntity(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/bookingsByUserId/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public List<booking> findBookingByUserId(@PathVariable("id") int userId) {
        return bookingService.viewBookingByUserId(userId);
    }

}
