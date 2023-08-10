package com.bnta.labwk6d3airline.services;

import com.bnta.labwk6d3airline.models.Flight;
import com.bnta.labwk6d3airline.models.FlightDTO;
import com.bnta.labwk6d3airline.models.Passenger;
import com.bnta.labwk6d3airline.repositories.FlightRepository;
import com.bnta.labwk6d3airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    // add details of a new flight --CHECK THIS

    public Flight addFlightDetails(FlightDTO flightDTO) {
        // this creates the flight with no passengers
        Flight flight = new Flight(
                flightDTO.getDestination(),
                flightDTO.getCapacity(),
                flightDTO.getDepartureDate(),
                flightDTO.getDepartureTime()
        );
        return flightRepository.save(flight); // return and store the new flight in database
    }

    // find by destination using derived query
    public List<Flight> findAllByDestination(String destination){
        return flightRepository.findByDestination(destination);
    }


    // display all available flights
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    // display specific flights
    public Flight findFlight(Long id) { // can add other parameters
        return flightRepository.findById(id).get();//need to add get as it returns an optional
    }

    // cancel flight
    public void cancelFlight(Long id) {
        Flight flightToCancel = flightRepository.findById(id).get();
        flightRepository.delete(flightToCancel);
    }

    public Flight bookAPassenger(Long flightId, Long passengerId) {
        Flight flightToBook = flightRepository.findById(flightId).get(); // get the flight

        Passenger passenger = passengerRepository.findById(passengerId).get();
        if(flightToBook.getPassengers().size()<flightToBook.getCapacity()){ // add passenger only if less than capacity
            flightToBook.addPassengers(passenger);
            flightRepository.save(flightToBook);
        }
        return flightToBook;
    }
}
