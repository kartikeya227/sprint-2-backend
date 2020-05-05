package org.com.dao;
import org.com.model.flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FlightRepository")
public interface FlightRepository extends JpaRepository<flight, Integer>{
}
