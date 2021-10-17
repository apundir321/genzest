package com.howtodoinjava.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.TimeSlot;

@Repository
public interface TimeSlotRepo extends JpaRepository<TimeSlot, Integer>{

	@Query("select t from TimeSlot t  where t.timeSlotName = ?1")
	TimeSlotRepo findByTimeSlotName(String timeSlotName);
	
	List<TimeSlot> findByTimeSlotStatus(String timeSlotStatus);
}
