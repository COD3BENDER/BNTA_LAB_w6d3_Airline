package com.bnta.labwk6d3airline.repositories;

import com.bnta.labwk6d3airline.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
