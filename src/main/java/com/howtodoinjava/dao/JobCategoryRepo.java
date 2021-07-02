package com.howtodoinjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.JobCategory;

@Repository
public interface JobCategoryRepo extends JpaRepository<JobCategory,Integer>{

	public JobCategory findByJobCategoryName(String jobCategoryName);
}

