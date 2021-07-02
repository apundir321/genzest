package com.howtodoinjava.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.SavedJobs;
import com.howtodoinjava.model.User;

@Repository
public interface SavedJobsRepo extends JpaRepository<SavedJobs,Integer>,SavedJobsCustomRepo{
	
	public List<SavedJobs> findAllByApplicant(User user);

}
