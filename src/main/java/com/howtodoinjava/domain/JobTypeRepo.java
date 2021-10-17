package com.howtodoinjava.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.JobType;
@Repository
public interface JobTypeRepo extends JpaRepository<JobType, Integer>{
	
	JobType findByJobTypeName(String jobTypeName);
	
	List<JobType> findByJobTypeStatus(String jobTypeStatus);

}
