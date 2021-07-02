package com.howtodoinjava.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.WorkExperience;

@Repository
public interface WorkExperienceRepo extends CrudRepository<WorkExperience, Integer> {

	
	
	
}
