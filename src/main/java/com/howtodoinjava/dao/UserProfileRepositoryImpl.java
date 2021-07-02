package com.howtodoinjava.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.RecruiterProfile;
import com.howtodoinjava.model.User;
import com.howtodoinjava.model.UserProfile;

@Repository
public interface UserProfileRepositoryImpl {
	
	public List<UserProfile> getUserProfiles(String location);
	
	public List<User> getUserBasedOnRole(String roleName);
	public List<RecruiterProfile> getUserBasedOnRoleParams(String roleName,Map<String, Object> searchCriteria);
	public User getUser(String recruiterProfileId) ;
	public List<UserProfile> getEmployeesBasedOnRoleParams(String roleName,Map<String, Object> searchCriteria);
}
