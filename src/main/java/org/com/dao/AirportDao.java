package org.com.dao;

import org.com.model.airport;

import java.util.List;
import java.util.Optional;

public interface AirportDao {
    public abstract List<airport> viewAirport();

    public abstract Optional<airport> viewAirport(String airportCode);

    public abstract void addAirport(airport airport);

    public abstract void updateAirport(airport airport);

    public abstract void deleteAirport(String airportCode);
}
