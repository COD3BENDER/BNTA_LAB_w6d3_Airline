package com.bnta.labwk6d3airline.services;

import com.bnta.labwk6d3airline.models.Passenger;
import com.bnta.labwk6d3airline.models.PassengerDTO;
import com.bnta.labwk6d3airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    // add New passenger
    public Passenger addNewPassenger(PassengerDTO passengerDTO) {
        // this creates the flight with no passengers
        Passenger passenger = new Passenger(
                passengerDTO.getName(),
                passengerDTO.getEmailAddress()
        );
        return passengerRepository.save(passenger);
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
