package com.bnta.labwk6d3airline.services;

import com.bnta.labwk6d3airline.models.Flight;
import com.bnta.labwk6d3airline.models.FlightDTO;
import com.bnta.labwk6d3airline.models.Passenger;
import com.bnta.labwk6d3airline.repositories.FlightRepository;
import com.bnta.labwk6d3airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    // add details of a new flight

    public Flight addFlightDetails(FlightDTO flightDTO){
        // this creates the flight
        Flight flight = new Flight(
                flightDTO.getDestination(),
                flightDTO.getCapacity(),
                flightDTO.getDepartureDate(),
                flightDTO.getDepartureTime()
        );

        return  flightRepository.save(flight); // return and store the new flight in database
    }



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
    public Flight bookPassenger(FlightDTO flightDTO, Long id){

        Flight flightToBook = flightRepository.findById(id).get(); // get the flight

        // this adds passengers to flight - maybe seperate the two
        for(Long passengerId : flightDTO.getPassengerIds()){
            // go through the list of passenger ids and create a passenger based on the id
            Passenger passenger = passengerRepository.findById(passengerId).get(); // use get as its given a optional otherwise
            // for extension maybe could check the capacity here before adding
            flightToBook.addPassengers(passenger); // add the passenger to the flight
        }
        flightRepository.save(flightToBook);
        return flightToBook;
    }

}
