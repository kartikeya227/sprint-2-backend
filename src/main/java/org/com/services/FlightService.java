package org.com.services;

import org.com.dao.FlightDao;
import org.com.dao.FlightRepository;
import org.com.model.flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService implements FlightDao {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void addFlight(flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void modifyFlight(flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public Optional<flight> viewFlight(int flightNumber) {
        return flightRepository.findById(flightNumber);
    }

    @Override
    public List<flight> viewFlight() {
        return flightRepository.findAll();
    }

    @Override
    public void deleteFlight(int flightNumber) {
        flightRepository.deleteById(flightNumber);
    }
}
