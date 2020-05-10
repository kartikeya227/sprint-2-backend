package org.com.dao;

import org.com.model.airport;
import org.com.model.scheduledFlight;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


public interface ScheduledFlightDao {
    public abstract void addScheduleFlight(scheduledFlight scheduledFlight);
    public abstract List<scheduledFlight> viewScheduledFlightsByAirportDate(String sourceAirportCode,String destinationAirportCode, Date arrivalDate, Date departureDate);
    public abstract List<scheduledFlight> viewScheduledFlights(int flightNumber);
    public abstract List<scheduledFlight> viewScheduledFlights();
    public abstract void modifyScheduledFlight(scheduledFlight scheduledFlight);
    public abstract void deleteScheduledFlight(int scheduleFlightId);
    public abstract Optional<scheduledFlight> scheduledFlightExists(int scheduledFlightId);

}
