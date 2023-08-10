package com.bnta.labwk6d3airline.components;

import com.bnta.labwk6d3airline.models.Flight;
import com.bnta.labwk6d3airline.models.Passenger;
import com.bnta.labwk6d3airline.repositories.FlightRepository;
import com.bnta.labwk6d3airline.repositories.PassengerRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Flight> flights = Arrays.asList(
                new Flight("New York",5,"10,10,2023","13:30:45"),
                new Flight("Scotland",6,"11,11,2023","14:40:43"),
                new Flight("Paris",4,"12,12,2023","15:20:24"),
                new Flight("Berlin",3,"13,12,2023","16:10:12")
        );

        List<Passenger> passengers = Arrays.asList(
                new Passenger("pass1","pass1@outlook.com"),
                new Passenger("pass2","pass2@gmail.com"),
                new Passenger("pass3","pass3@hotmail.com"),
                new Passenger("pass4","pass4@email.com")
        );

        for (Flight flight : flights) {
            Flight flightName = new Flight(flight.getDestination(),flight.getCapacity(), flight.getDepartureDate(), flight.getDepartureTime());
            flightRepository.save(flightName);
        }

        for (Passenger passenger : passengers) {
            Passenger passengerName = new Passenger(passenger.getName(), passenger.getEmailAddress());
            passengerRepository.save(passengerName);
        }
    }
}
