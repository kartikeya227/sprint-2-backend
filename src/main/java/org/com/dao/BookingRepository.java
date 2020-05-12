package org.com.dao;

import org.com.model.booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("BookingRepository")
public interface BookingRepository extends JpaRepository<booking, Integer> {
}