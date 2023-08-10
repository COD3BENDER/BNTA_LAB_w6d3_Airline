package com.bnta.labwk6d3airline.controllers;

import com.bnta.labwk6d3airline.models.Flight;
import com.bnta.labwk6d3airline.models.FlightDTO;
import com.bnta.labwk6d3airline.models.Passenger;
import com.bnta.labwk6d3airline.repositories.FlightRepository;
import com.bnta.labwk6d3airline.repositories.PassengerRepository;
import com.bnta.labwk6d3airline.services.FlightService;
import com.bnta.labwk6d3airline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    // Display all available flights

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.findAllFlights(),HttpStatus.FOUND);
    }

    // Display details of a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id),HttpStatus.FOUND);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> postFlight(@RequestBody FlightDTO flightDTO){
        Flight addFlight = flightService.addFlightDetails(flightDTO);
        return new ResponseEntity<>(addFlight, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{flightId}/{passengerId}")
    public ResponseEntity<Flight> addPassenger(@PathVariable  Long passengerId, @PathVariable Long flightId){
        Flight flight = flightService.bookAPassenger(flightId,passengerId);
        return new ResponseEntity<>(flight,HttpStatus.ACCEPTED);
    }

    // - Cancel a flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }











}
