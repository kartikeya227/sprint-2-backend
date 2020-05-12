package org.com.dao;

import org.com.model.booking;

import java.util.List;
import java.util.Optional;

public interface BookingDao {
    public abstract void addBooking(booking booking);

    public abstract void modifyBooking(booking booking);

    public abstract Optional<booking> viewBooking(int bookingId);

    public abstract List<booking> viewBooking();

    public abstract List<booking> viewBookingByUserId(int userId);

    public abstract void deleteBooking(int bookingId);
}
