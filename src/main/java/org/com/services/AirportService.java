package org.com.services;

import java.util.Optional;

import org.com.dao.AirportDao;
import org.com.dao.AirportRepository;
import org.com.model.airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService implements AirportDao {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public List<airport> viewAirport() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<airport> viewAirport(String airportCode) {
        return airportRepository.findById(airportCode);
    }

    @Override
    public void addAirport(airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public void updateAirport(airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(String airportCode) {
        airportRepository.deleteById(airportCode);
    }
}
