package org.com.dao;
import org.com.model.schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ScheduleRepository")
public interface ScheduleRepository extends JpaRepository<schedule, Integer>{
}