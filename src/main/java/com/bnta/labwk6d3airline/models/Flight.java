package com.bnta.labwk6d3airline.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String destination;
    @Column
    private int capacity;
    @Column
    private String departureDate;
    @Column
    private String departureTime;

    @JsonIgnoreProperties("flights")
    @ManyToMany()
    @JoinTable( //the owner of the many to many relationship gets the @jointable
            name = "flights_passengers", // if you have a good name give it one if not put the two table names table1_table2
            joinColumns = @JoinColumn(name = "flight_id"), // we are in this class thats why we make it the join column
            inverseJoinColumns = @JoinColumn(name = "passenger_id")// inverse join column is the other table
    )
    private List<Passenger> passengers;

    public Flight(){

    }

    public Flight(String destination, int capacity, String departureDate, String departureTime){
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassengers(Passenger passenger){
        this.passengers.add(passenger);
    }
}
