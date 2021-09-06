package com.howtodoinjava.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.JobAccount;
import com.howtodoinjava.entity.JobAccountApplication;
import com.howtodoinjava.model.User;

@Repository
public interface JobAccountApplicationRepo extends JpaRepository<JobAccountApplication,Long>{
	
	public List<JobAccountApplication> findAllByApplicant(com.howtodoinjava.model.User user);
	
	public List<JobAccountApplication> findByJob(JobAccount job);
	
	@Transactional
	@Modifying
    @Query("delete from JobAccountApplication e where applicant = ?1 and job = ?2")
	public void deleteAppliedJob(User applicant,JobAccount job);
	
	public List<JobAccountApplication> findAllByApplicantAndStatus(User applicant, String status);

}
