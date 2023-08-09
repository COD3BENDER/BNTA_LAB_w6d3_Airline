package com.bnta.labwk6d3airline.repositories;

import com.bnta.labwk6d3airline.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
}
