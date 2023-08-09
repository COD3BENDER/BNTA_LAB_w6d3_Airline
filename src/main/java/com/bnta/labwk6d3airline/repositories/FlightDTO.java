package com.bnta.labwk6d3airline.repositories;

import java.util.List;

public class FlightDTO {

    private String name;
    private List<Long> passengerIds;

    public FlightDTO() {

    }

    public FlightDTO(String name, List<Long> passengerIds) {
        this.name = name;
        this.passengerIds = passengerIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(List<Long> passengerIds) {
        this.passengerIds = passengerIds;
    }
}
