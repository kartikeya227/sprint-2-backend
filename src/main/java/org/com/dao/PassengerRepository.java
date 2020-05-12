package org.com.dao;

import org.com.model.passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("PassengerRepository")
public interface PassengerRepository extends JpaRepository<passenger, Integer> {
}