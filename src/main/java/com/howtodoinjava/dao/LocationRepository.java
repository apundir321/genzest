package com.howtodoinjava.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

	public Location findByLocation(String location);
	
	
	
}
