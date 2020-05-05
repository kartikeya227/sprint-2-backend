package org.com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Table(name = "passenger")
public class passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pnrNumber;

    @Column(name = "passengerName")
    private String passengerName;

    @Column(name = "passengerAge")
    private int passengerAge;

    @Column(name = "passengerUin")
    private BigInteger passengerUin;

    @Column(name = "luggage")
    private double luggage;

    @Override
    public String toString() {
        return "passenger{" +
                "pnrNumber=" + pnrNumber +
                ", passengerName='" + passengerName + '\'' +
                ", passengerAge=" + passengerAge +
                ", passengerUin=" + passengerUin +
                ", luggage=" + luggage +
                '}';
    }

    public int getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(int pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public BigInteger getPassengerUin() {
        return passengerUin;
    }

    public void setPassengerUin(BigInteger passengerUin) {
        this.passengerUin = passengerUin;
    }

    public double getLuggage() {
        return luggage;
    }

    public void setLuggage(double luggage) {
        this.luggage = luggage;
    }
}
