package com.bnta.labwk6d3airline.repositories;

import com.bnta.labwk6d3airline.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
