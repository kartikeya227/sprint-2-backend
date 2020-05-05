package org.com.dao;

import org.com.model.flight;

import java.util.List;
import java.util.Optional;

public interface FlightDao {
    public abstract void addFlight(flight flight);
    public abstract void modifyFlight(flight flight);
    public abstract Optional<flight> viewFlight(int flightNumber);
    public abstract List<flight> viewFlight();
    public abstract void deleteFlight(int flightNumber);
}
