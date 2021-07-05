package com.howtodoinjava.domain;

import java.util.List;
import java.util.Map;

import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.SearchCandidate;
import com.howtodoinjava.entity.SearchJobs;
import com.howtodoinjava.model.UserProfile;

public interface JobAccountCustomRepo {
	
	
	List<JobAccount> findJobsByJobCriterias(SearchJobs searchJob);
	
	List<JobAccount> findJobsByCategory(Category category);
	
	public   List<Object[]> findJobAcountByCateory();
	
	public List<UserProfile> findProfileByProfileCriterias(SearchCandidate searchCandidate);

}
