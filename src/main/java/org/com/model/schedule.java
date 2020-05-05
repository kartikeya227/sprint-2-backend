package org.com.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "schedule")
public class schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scheduleId;

    @OneToOne
    @JoinColumn(name = "Airport_Code_S")
    private airport sourceAirport;

    @OneToOne
    @JoinColumn(name = "Airport_Code_D")
    private airport destinationAirport;

    @Basic
    private java.sql.Date arrivalDate;

    @Basic
    private java.sql.Time arrivalTime;

    @Basic
    private java.sql.Date departureDate;

    @Basic
    private java.sql.Time departureTime;

    @Override
    public String toString() {
        return "schedule{" +
                "scheduleId=" + scheduleId +
                ", sourceAirport=" + sourceAirport +
                ", destinationAirport=" + destinationAirport +
                ", arrivalDate=" + arrivalDate +
                ", arrivalTime=" + arrivalTime +
                ", departureDate=" + departureDate +
                ", departureTime=" + departureTime +
                '}';
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }
}