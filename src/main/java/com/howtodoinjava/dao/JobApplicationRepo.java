package com.howtodoinjava.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.model.JobApplication;
import com.howtodoinjava.model.User;

@Repository
public interface JobApplicationRepo extends JpaRepository<JobApplication,Integer>{

	public Page<JobApplication> findAllByApplicant(User user,Pageable page);
}

