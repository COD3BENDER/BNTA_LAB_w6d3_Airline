package com.bnta.labwk6d3airline.controllers;

import com.bnta.labwk6d3airline.models.Passenger;
import com.bnta.labwk6d3airline.repositories.PassengerRepository;
import com.bnta.labwk6d3airline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    // display all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers(){
        return new ResponseEntity(passengerService.displayAllPassengers(), HttpStatus.FOUND);
    }

    //display a specific passenger
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        return new ResponseEntity(passengerService.findPassenger(id),HttpStatus.FOUND);
    }

    // add passengers
    @PostMapping
    public ResponseEntity<List<Passenger>> postPassenger(@RequestBody Passenger passenger){
        passengerService.savePassenger(passenger);
        return new ResponseEntity(passengerService.displayAllPassengers(),HttpStatus.CREATED);
    }
}
