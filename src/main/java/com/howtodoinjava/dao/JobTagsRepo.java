package com.howtodoinjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.JobTags;

@Repository
public interface JobTagsRepo extends JpaRepository<JobTags, Long>{
	
	public JobTags findByName(String name);
}
