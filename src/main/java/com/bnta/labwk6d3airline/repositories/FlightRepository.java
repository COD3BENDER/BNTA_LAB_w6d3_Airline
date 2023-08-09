package com.bnta.labwk6d3airline.repositories;

import com.bnta.labwk6d3airline.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
