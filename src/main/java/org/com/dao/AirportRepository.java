package org.com.dao;
import org.com.model.airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("AirportRepository")
public interface AirportRepository extends JpaRepository<airport, String>{
}
