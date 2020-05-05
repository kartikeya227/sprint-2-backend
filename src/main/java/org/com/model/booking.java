package org.com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "booking")
public class booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    private int cost;

    private int noOfPassengers;
    @OneToOne
    @JoinColumn(name = "User_Id_FK")
    private users user;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "Passenger_FK")
    @OrderColumn(name="Seq_FK")
    private List<passenger> passengerList;

    @OneToOne
    @JoinColumn(name = "Scheduled_Flight_FK")
    private scheduledFlight scheduledFlight;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public List<passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public org.com.model.scheduledFlight getScheduledFlight() {
        return scheduledFlight;
    }

    public void setScheduledFlight(org.com.model.scheduledFlight scheduledFlight) {
        this.scheduledFlight = scheduledFlight;
    }
}