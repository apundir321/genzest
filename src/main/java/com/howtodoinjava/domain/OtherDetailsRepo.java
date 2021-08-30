package com.howtodoinjava.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.entity.JobType;
import com.howtodoinjava.model.OtherUserDetails;

@Repository
public interface OtherDetailsRepo extends JpaRepository<OtherUserDetails, Integer>{ 

}
