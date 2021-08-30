package com.howtodoinjava.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.Category;
import com.howtodoinjava.entity.JobAccount;
@Repository
public interface JobAccountRepo extends JpaRepository<JobAccount, Integer>{
	
	public JobAccount findByJobCode(String jobCode);
	
}
