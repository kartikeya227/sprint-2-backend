package org.com.services;

import org.com.dao.BookingDao;
import org.com.dao.BookingRepository;
import org.com.model.booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements BookingDao {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void addBooking(booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void modifyBooking(booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Optional<booking> viewBooking(int bookingId) {
        return bookingRepository.findById(bookingId);
    }

    @Override
    public List<booking> viewBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
