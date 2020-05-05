package org.com.model;

import java.sql.Date;

public class scheduledFlightSearch {
    private airport arrivalAirport;
    private airport departureAirport;
    private Date arrivalDate;
    private Date departureDate;

    @Override
    public String toString() {
        return "scheduledFlightSearch{" +
                "arrivalAirport=" + arrivalAirport +
                ", departureAirport=" + departureAirport +
                ", arrivalDate=" + arrivalDate +
                ", departureDate=" + departureDate +
                '}';
    }

    public airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}
