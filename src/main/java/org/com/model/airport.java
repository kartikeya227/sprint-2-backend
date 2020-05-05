package org.com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "airport")
public class airport {
    @Id
    @NotNull(message = "can't be empty")
    @Column(name = "Airport_Code")
    private String airportCode;

    @NotNull(message = "can't be empty")
    private String airportName;

    @NotNull(message = "can't be empty")
    private String airportLocation;

    @Override
    public String toString() {
        return "airport{" +
                "airportCode='" + airportCode + '\'' +
                ", airportName='" + airportName + '\'' +
                ", airportLocation='" + airportLocation + '\'' +
                '}';
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

}
