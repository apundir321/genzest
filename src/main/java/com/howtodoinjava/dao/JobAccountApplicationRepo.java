package com.howtodoinjava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobAccountApplication;

@Repository
public interface JobAccountApplicationRepo extends JpaRepository<JobAccountApplication,Long>{
	
	public List<JobAccountApplication> findAllByApplicant(com.howtodoinjava.model.User user);
	
	public List<JobAccountApplication> findByJob(JobAccount job);

}
