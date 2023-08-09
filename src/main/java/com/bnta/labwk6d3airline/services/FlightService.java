package com.bnta.labwk6d3airline.services;

import com.bnta.labwk6d3airline.models.Flight;
import com.bnta.labwk6d3airline.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    // add details of a new flight



    // display all available flights
    public List<Flight> findAllFlights(){
        return flightRepository.findAll();
    }

    // display specific flights
    public Flight findFlight(Long id){ // can add other parameters
        return flightRepository.findById(id).get();//need to add get as it returns an optional
    }

    // cancel flight


    // book passenger on flight

}
