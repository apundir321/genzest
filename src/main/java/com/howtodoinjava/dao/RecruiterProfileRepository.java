package com.howtodoinjava.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.RecruiterProfile;

@Repository
public interface RecruiterProfileRepository extends CrudRepository<RecruiterProfile, Integer> {
	
	

}
