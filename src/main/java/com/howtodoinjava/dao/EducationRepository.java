package com.howtodoinjava.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.Education;

@Repository
public interface EducationRepository extends CrudRepository<Education, Integer> {

	
	
	
}
