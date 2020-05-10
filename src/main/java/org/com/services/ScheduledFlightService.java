package org.com.services;


import org.com.dao.ScheduledFlightDao;
import org.com.dao.ScheduledFlightRepository;

import org.com.model.airport;
import org.com.model.flight;
import org.com.model.schedule;
import org.com.model.scheduledFlight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.*;

@Service
public class ScheduledFlightService implements ScheduledFlightDao {
    @Autowired
    private ScheduledFlightRepository scheduledFlightRepository;

    @Override
    public void addScheduleFlight(scheduledFlight scheduledFlight) {
        scheduledFlightRepository.save(scheduledFlight);
    }

    @Override
    public List<scheduledFlight> viewScheduledFlightsByAirportDate(String sourceAirportCode, String destinationAirportCode, Date arrivalDate, Date departureDate) {
        List<scheduledFlight> list = new ArrayList<scheduledFlight>();
        list=scheduledFlightRepository.findAll();
        List<scheduledFlight> rlist = new ArrayList<scheduledFlight>();
        for(int i =0; i<list.size();i++){
            scheduledFlight scheduledFlight=list.get(i);
            schedule schedule=scheduledFlight.getSchedule();
            airport airport = schedule.getSourceAirport();
            airport airport_d=scheduledFlight.getSchedule().getDestinationAirport();
            if((airport.getAirportCode().equals(sourceAirportCode))&&(airport_d.getAirportCode().equals(destinationAirportCode)))
            {
                System.out.println(arrivalDate.toString()+" 111 "+schedule.getArrivalDate());
                if(schedule.getArrivalDate().after(arrivalDate)&&schedule.getArrivalDate().before(departureDate)){
                    System.out.println(arrivalDate.toString()+" 222 "+schedule.getArrivalDate());
                    rlist.add(scheduledFlight);
                }
                else if(schedule.getArrivalDate().toString().equals(arrivalDate.toString())){
                    System.out.println(arrivalDate.toString()+" 222 "+schedule.getArrivalDate());
                    rlist.add(scheduledFlight);
                }
                else if(schedule.getArrivalDate().toString().equals(departureDate.toString())){
                    System.out.println(arrivalDate.toString()+" 222 "+schedule.getArrivalDate());
                    rlist.add(scheduledFlight);
                }
            }
        }
        System.out.println("hi/n/n/n/n/n/n/n");
        
        return rlist;
    }

    @Override
    public List<scheduledFlight> viewScheduledFlights(int flightNumber) {
        List<scheduledFlight> list = new ArrayList<scheduledFlight>();
        list=scheduledFlightRepository.findAll();
        List<scheduledFlight> rlist = new ArrayList<scheduledFlight>();
        for(int i =0; i<list.size();i++){
            scheduledFlight scheduledFlight=list.get(i);
            flight flight=scheduledFlight.getFlight();
            if(flight.getFlightNumber()==flightNumber){
                rlist.add(scheduledFlight);
            }
        }
        return rlist;
    }



    @Override
    public List<scheduledFlight> viewScheduledFlights() {
        return scheduledFlightRepository.findAll();
    }

    @Override
    public void modifyScheduledFlight(scheduledFlight scheduledFlight) {
        scheduledFlightRepository.save(scheduledFlight);
    }

    @Override
    public void deleteScheduledFlight(int scheduleFlightId) {
        scheduledFlightRepository.deleteById(scheduleFlightId);
    }

    @Override
    public Optional<scheduledFlight> scheduledFlightExists(int scheduledFlightId) {
        return scheduledFlightRepository.findById(scheduledFlightId);
    }


}
