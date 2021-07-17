package com.howtodoinjava.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.Employer;
import com.howtodoinjava.entity.JobType;
import com.howtodoinjava.entity.TimeSlot;
@Repository
public interface EmployerRepo extends JpaRepository<Employer, Integer>{

	Employer findByEmployerName(String employerName);
	
	Employer findByClientCode(String clientCode);

}
