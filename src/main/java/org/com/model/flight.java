package org.com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Table(name = "flight")
public class flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Flight_Id")
    private int flightNumber;

    @Column(name = "flightModel", nullable = false)
    @NotNull(message = "can't be blank.")
    private String flightModel;

    @Column(name = "CarrierName", nullable = false)
    @NotNull(message = "can't be blank.")
    private String carrierName;

    @Column(name = "seatCapacity", nullable = false)
    @NotNull(message = "can't be blank.")
    private int seatCapacity;


    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    @Override
    public String toString() {
        return "flight{" +
                "flightNumber=" + flightNumber +
                ", flightModel='" + flightModel + '\'' +
                ", carrierName='" + carrierName + '\'' +
                ", seatCapacity=" + seatCapacity +
                '}';
    }

}
