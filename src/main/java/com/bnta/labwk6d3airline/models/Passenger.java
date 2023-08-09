package com.bnta.labwk6d3airline.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column(name = "email_address")
    private String emailAddress;

    @JsonIgnoreProperties("passengers")
    @ManyToMany()
    @JoinTable( //the owner of the many to many relationship gets the @jointable
            name = "passengers_flights", // if you have a good name give it one if not put the two table names table1_table2
            joinColumns = @JoinColumn(name = "passenger_id"), // we are in this class thats why we make it the join column
            inverseJoinColumns = @JoinColumn(name = "flight_id")// inverse join column is the other table
    )
    private List<Flight> flights;

    public Passenger(){

    }

    public Passenger(String name, String emailAddress){
        this.name = name;
        this.emailAddress = emailAddress;
        this.flights = new ArrayList<>();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
