package com.howtodoinjava.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.Job;
import com.howtodoinjava.model.JobCategory;
@Repository
public interface JobRepository extends JpaRepository<Job, Long>,JobRepoCustom {

	@Query("select j from Job j where j.category = ?1")
    List<Job> findJobByCategory(JobCategory category);
	
	Page<Job> findAll(Pageable pagaeble);
}
