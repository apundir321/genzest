package com.howtodoinjava.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.Job;
import com.howtodoinjava.model.Organization;

@Repository
public interface JobRepoCustom {
	
	List<Job> findJobsByJobCriterias(Map<String,String> searchCriteria);
	
	Page<Job> findJobsByTags(List<String> tags,Map<String, Object> searchCriteria);
	
	public List<Organization> findOrgsByCriteria(Map<String, Object> searchCriteria);
	
	
	

}
