package com.bnta.labwk6d3airline.services;

import com.bnta.labwk6d3airline.models.Passenger;
import com.bnta.labwk6d3airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    // add new passenger
    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger); // repository method via extended JPA
    }

    // display details of all passengers
    public List<Passenger> displayAllPassengers(){
        return passengerRepository.findAll();
    }

    // display details of a specific passenger
    public Passenger findPassenger(Long id){
        return  passengerRepository.findById(id).get();
    }
}
