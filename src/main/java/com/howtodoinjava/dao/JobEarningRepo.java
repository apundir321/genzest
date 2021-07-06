package com.howtodoinjava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.JobEarning;
import com.howtodoinjava.model.User;

@Repository
public interface JobEarningRepo extends JpaRepository<JobEarning,Integer>{
	
	public List<JobEarning> findByApplicantUser(User user);

}
