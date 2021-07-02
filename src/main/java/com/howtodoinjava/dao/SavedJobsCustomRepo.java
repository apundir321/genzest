package com.howtodoinjava.dao;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.SavedJobs;

@Repository
public interface SavedJobsCustomRepo {
	
	SavedJobs findSavedJobByUserIdAndJobId(String userId,String jobId);
	
	

}
