package org.com.dao;

import org.com.model.scheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ScheduledFlightRepository")
public interface ScheduledFlightRepository extends JpaRepository<scheduledFlight, Integer> {
}
