package org.com.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "scheduledFlight ")
public class scheduledFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scheduleFlightId;

    private int availableSeats;

    @OneToOne
    @JoinColumn(name = "Flight_Id")
    private flight flight;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Schedule_Id")
    private schedule schedule;

    private double costPerTicket;

    @Override
    public String toString() {
        return "scheduledFlight{" +
                "scheduleFlightId=" + scheduleFlightId +
                ", availableSeats=" + availableSeats +
                ", flight=" + flight +
                ", schedule=" + schedule +
                ", costPerTicket=" + costPerTicket +
                '}';
    }

    public int getScheduleFlightId() {
        return scheduleFlightId;
    }

    public void setScheduleFlightId(int scheduleFlightId) {
        this.scheduleFlightId = scheduleFlightId;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public org.com.model.flight getFlight() {
        return flight;
    }

    public void setFlight(org.com.model.flight flight) {
        this.flight = flight;
    }

    public org.com.model.schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(org.com.model.schedule schedule) {
        this.schedule = schedule;
    }

    public double getCostPerTicket() {
        return costPerTicket;
    }

    public void setCostPerTicket(double costPerTicket) {
        this.costPerTicket = costPerTicket;
    }
}